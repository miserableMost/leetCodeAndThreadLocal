package findJob.second.threadpool;

import java.util.concurrent.*;

/**
 * @author 李聪
 * @date 2020/1/24 16:30
 * 为什么用线程池，优势？
 * 线程池做的工作主要是控制运行的线程的数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果数量超过了最大数量超出数量的线程的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行
 *
 * 他的主要特点为:线程复用：控制最大并发数：管路线程
 *
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 * java中的线程池是通过Executor框架实现的，该框架中用到了Executor,Executors,ExecutorService,ThreadPoolExecutor这几个类。
 */

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        threadPoolInit();
        //知道硬件资源
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadpool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try{
            for (int i = 1; i <= 9; i++) {
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
            //暂停一会线程
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            threadpool.shutdown();
        }
        System.out.println(Thread.currentThread().getName() + "\t办理业务");
        //Array Arrays
        //Collection collection
        //Executor Executors
    }
    public static void threadPoolInit() {
        // ExecutorService threadpool = Executors.newFixedThreadPool(5);//一池5个处理线程
        //ExecutorService threadpool = Executors.newSingleThreadExecutor();//一池处理一个线程
        ExecutorService threadpool = Executors.newCachedThreadPool();      //一池处理N个线程
        try{
            for (int i = 1; i <= 9; i++) {
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
            //暂停一会线程
            try{
                TimeUnit.SECONDS.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            threadpool.shutdown();
        }
    }
}
//死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待现象，若物理