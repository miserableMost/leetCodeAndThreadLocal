package sort;

import java.util.concurrent.TimeUnit;

/**
 * @author 李聪
 * @date 2020/9/2 20:57
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1");
                //暂停一会线程
                try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + " waiting for resource2......");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2");
                }
            }
        },"线程1").start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " get resource2");
                //暂停一会线程
                try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + " waiting for resource1......");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " get resource1");
                }
            }
        },"线程2").start();
    }
}
