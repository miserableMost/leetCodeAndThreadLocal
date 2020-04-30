package findJob.second.JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 李聪
 * @date 2020/1/21 15:07
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);   //模拟3个车位,伸缩性
        for(int i = 1;i <= 6;i ++) { //模拟6部汽车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    //暂停一会线程
                    try{
                        TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                }catch (InterruptedException e){
                e.printStackTrace();
              }
            },String.valueOf(i)).start();
        }
    }
}
