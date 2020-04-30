package findJob.second.blockQueue;

/**
 * @author 李聪
 * @date 2020/1/22 14:04
 *
 * ArrayBlockingQueue:是一个基于数据结构的有界阻塞队列，此队列按FIFO(先进先出）原则对元素进行排序。
 * LinkedBlockingQueue: 一个基于链表结构的阻塞队列，此队列按FIFO(先进先出）排序元素，吞吐量通常要高于ArrayBlockingQueue.
 * SynchronousQueue: 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高
 *
 * 1 队列
 *
 * 2 阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *
 *  2.2 不得不阻塞，你如何管理
 *
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列，顾名思义，首先它是一个队列，而一个阻塞队列在数据结构中所起的作用大致如下图所示：
 *
 * 线程1往阻塞队列中添加元素，而线程2从阻塞队列中移除元素
 * 当阻塞队列是空时，从队列中获取元素的操作将会被阻塞。
 * 当阻塞队列是满时，从队列里添加元素的操作将会被阻塞。
 *
 * 试图从空的阻塞队列中获取元素的线程将会被阻塞，知道其他的线程往空的度列插入新的元素。
 * 同样
 * 试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程从列中移除一个或者多个元素或者完全清空队列使队列重新变得空闲起来并后续新增
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        //List list = null;
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));

    }
}
