package findJob.second;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;
    public HoldLockThread(String lockA,String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获得： " + lockB);
            //暂停一会线程
            try{
                TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e){e.printStackTrace();}
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockB + "\t尝试获得： " + lockA);
            }
        }
    }
}
/**
 * @author 李聪
 * @date 2020/1/24 23:53
 * 死锁是指两个或两个以上的进程在执行过程中，因
 * 争夺资源而造成的一种互相等待现象，
 * 若无外力干涉那它们都将无法推进下去
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"threadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"threadBBB").start();
        /**
         * linux ps -ef|grep xxx ls -l
         * windows下的java运行程序 也有类似ps的查看进程的命令，但是目前我们需要查看的只是java
         * jps = java ps jps -l
         * jps命令定位进程号
         * jstack找到死锁查看
         */
    }
}
