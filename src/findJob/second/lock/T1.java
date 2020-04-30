package findJob.second.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李聪
 * @date 2020/1/20 16:04
 */
// 公平锁：是指多个线程按照申请锁的顺序来获取锁，类似排队打饭，先来后到。
// 非公平锁：是指多个线程获取锁的顺序并不是按照申请锁的顺序，
// 有可能后申请的线程比先申请的线程优先获取锁在高并发的情况下，有可能会造成优先级反转或者饥饿现象。

/**
 * 公平锁、非公平锁
 *     并发包中ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或非公平锁，默认是非公平锁。
 * 关于两者区别：
 * 公平锁：Threads acquire a fair lock in the order in which they requested it
 * 公平锁,就是很公平，在并发环境中，每个线程在获取锁时会先查看此锁维护的等待队列，如果为空，或者当前线程是等待队列的第一个，就占有锁，
 * 否则就会加入到等到队列中，以后会按照FIFO的规则从队列中取到自己。
 *
 * 非公平锁：a nonfair lock permits barging:threads requesting a lock can jump ahead of queue of waiting threads if the lock
 * happens to be available when it is requested.
 * 非公平锁比较粗鲁，上来就直接尝试占有锁，如果尝试失败，就再采用类似公平锁那种方式。
 *
 * Java ReentrantLock而言
 * 通过构造函数指定该锁是否是公平锁，默认是非公平锁。非公平锁的优点在于吞吐量比公平锁大。
 * 对于Synchronized而言，也是一种非公平锁。
  */


public class T1 {
    volatile int n = 0;
    public void add() {
        n ++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);

    }
}
/**
 独占锁：指该锁一次只能被一个线程所持有。对ReentrantLock和Synchronized而言都是独占锁
 共享锁：指该锁可被多个线程所持有。对ReentrantReadWriteLock其读锁是共享锁，其写锁是独占锁。
 读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。
sync --->> lock -->>ReentrantReadWriteLock
 */