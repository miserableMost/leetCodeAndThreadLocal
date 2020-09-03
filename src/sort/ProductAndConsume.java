package sort;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李聪
 * @date 2020/8/14 23:52
 */
public class ProductAndConsume {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.product();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.consume();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }


}
class ShareData {
    private volatile int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition product = lock.newCondition();
    private Condition consume = lock.newCondition();

    public void product() throws InterruptedException {
        try{
            lock.lock();
            while(num != 0) {
                product.await();
            }
            num ++;
            System.out.println(Thread.currentThread().getName() + "生产者生产了");
            consume.signal();
        }finally {
            lock.unlock();
        }
    }
    public void consume() throws InterruptedException {
        try{
            lock.lock();
            while(num == 0){
                consume.await();
            }
            num --;
            System.out.println(Thread.currentThread().getName() + "消费者消费了");
            product.signal();
        }finally {
            lock.unlock();
        }
    }
}
