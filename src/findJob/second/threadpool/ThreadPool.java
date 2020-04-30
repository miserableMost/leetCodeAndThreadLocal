package findJob.second.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "***come in Callable");
        //暂停一会线程
        try{
            TimeUnit.SECONDS.sleep(10);}catch(InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}
/**
 * @author 李聪
 * @date 2020/1/23 20:36
 * java
 * 多线程中，第三种获取多线程的方式
 */
public class ThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //m1
        //m2
        //m3
        //两个线程，一个Main主线程，一个AAfutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask2,"BB").start();

        //int result02 = futureTask.get();
        System.out.println(Thread.currentThread().getName() + "********");
        int result01 = 100;
        while(!futureTask.isDone()) {

        }
        int result02 = futureTask.get();//建议放到最后，要求获得callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成
        System.out.println("****result: " + (result01 + result02));

    }
}
