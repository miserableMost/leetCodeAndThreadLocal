package findJob.second.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 李聪
 * @date 2020/1/8 18:20
 */
public class ABADemo {      //ABA问题解决   AtomicStampedReference

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        System.out.println("======以下是ABA问题的产生=======");
        new Thread(() -> {
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();
        new Thread(() -> {
            //暂停1秒钟t2线程，保证上面的t1线程完成了一次ABA操作
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t" + atomicReference.get());
        },"t2").start();
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("======以下是ABA问题的解决=======");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号：" + stamp);
            //暂停1秒钟t3线程,为使t4也拿到stamp
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t第二次版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t第三次版本号：" + atomicStampedReference.getStamp());
            },"t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号：" + stamp);
            //暂停1秒钟t3线程
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch(Exception e){
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功否："+result+"\t当前最新实际版本号："+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t当前实际最新值："+atomicStampedReference.getReference());
        },"t4").start();
    }
}
