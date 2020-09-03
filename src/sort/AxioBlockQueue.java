package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李聪
 * @date 2020/8/14 23:36
 */
public class AxioBlockQueue {
    private List<Integer> list = new ArrayList<>();
    private volatile int size,capacity;
    private Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isNull = lock.newCondition();

    public AxioBlockQueue(int capacity){
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(int data) throws InterruptedException {
        try{
            lock.lock();
            while(size >= capacity) {
                System.out.println("队列已满");
                isFull.await();
            }
            list.add(data);
            size ++;
        }finally {
            lock.unlock();
        }
    }
    public int get() throws InterruptedException {
        try {
            lock.lock();
            while(size <= 0) {
                System.out.println("队列已空");
                isNull.await();
            }
            int res = list.remove(0);
            size --;
            return res;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AxioBlockQueue axioBlockQueue = new AxioBlockQueue(5);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    axioBlockQueue.add(i);
                    System.out.println(Thread.currentThread().getName() + "往队列塞入" + i);
                    //暂停一会线程
                    try{
                        TimeUnit.MILLISECONDS.sleep(600);}catch(InterruptedException e){e.printStackTrace();}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "从队列取出" + axioBlockQueue.get());
                    //暂停一会线程
                    try{TimeUnit.MILLISECONDS.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
