package findJob.second.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName()+ "\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ######invoked sendEmail()");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get() {
        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t ######invoked set()");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * @author 李聪
 * @date 2020/1/20 16:35
 *  * 可重入锁(也叫做递归锁）? ---拿到门外的大锁--厨房、卫生间锁都有
 *  * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *  * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *  * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 *  * 作用--避免死锁
 *
 *  case one
 *  t1	 invoked sendSMS()                  t1线程在外层方法获取锁的时候
 * t1	 ######invoked sendEmail()          t1在进入内层方法会自动获取锁
 * t2	 invoked sendSMS()
 * t2	 ######invoked sendEmail()
 *
 * case two
 * ReentrantLock就是一个典型的可重入锁
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try{
                phone.sendSMS();
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(() -> {
            try{
                phone.sendSMS();
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        //暂停一会线程
        try{
            TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");
        t3.start();
        t4.start();
    }
}

