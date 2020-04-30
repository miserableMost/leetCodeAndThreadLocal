package findJob.second.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 李聪
 * @date 2020/1/22 20:00
 */
public class SychronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(() -> {
            try{
               //暂停一会线程
               try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
                try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
                try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
