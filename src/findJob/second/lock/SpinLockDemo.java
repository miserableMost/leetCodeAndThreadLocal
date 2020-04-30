package findJob.second.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 李聪
 * @date 2020/1/21 12:38
 */
//自旋锁(spinlock)
//是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in 0(n_n)O");
        while(!atomicReference.compareAndSet(null,thread)) {

        }
    }
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnlock()");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            //暂停一会线程
            try{
                TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
            spinLockDemo.myUnlock();
        },"AA").start();

        //暂停一会线程
        try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}

        new Thread(() -> {
            spinLockDemo.myLock();
            try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            spinLockDemo.myUnlock();
        },"BB").start();
    }
}
