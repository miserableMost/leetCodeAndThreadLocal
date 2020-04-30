package findJob.second.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @author 李聪
 * @date 2020/1/21 14:24
 *
 * CountDownLatch
 * 1.让一些线程阻塞直到另一些线程完成一系列操作才被唤醒
 * 2.CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，调用线程会被阻塞。其他线程调用countDown方法会将计数器减1（调用countDown方法的线程
 * 不会阻塞),当计数器的值变为零时，因调用await方法被阻塞的线程会被唤醒，继续执行
 * 3.CountDownLatchDemo
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1;i <= 6;i ++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                countDownLatch.countDown();
            },String.valueOf(CountryEnum.forEach_CountryEnum(i).getRetMessage())).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ******秦帝国一统天下");
        System.out.println();

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1;i <= 6;i ++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ******88班长最后关门走人");
    }
}
