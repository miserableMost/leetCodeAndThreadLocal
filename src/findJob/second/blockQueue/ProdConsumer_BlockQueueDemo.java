package findJob.second.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while(FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName()+"\t插入队列" + data +"成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t大老板叫停了，便是flag=false,生产动作结束");
    }
    public void myCosumer() throws Exception {
        String result = null;
        while(FLAG) {
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t超过两秒钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列蛋糕" + result + "成功");
        }
    }
    public void stop() throws Exception {
        this.FLAG = false;
    }
}
/**
 * @author 李聪
 * @date 2020/1/22 22:13
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try{
                myResource.myProd();
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"prod").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try{
                myResource.myCosumer();
                System.out.println();
                System.out.println();
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        //暂停一会线程
        try{TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板叫停，活动结束");
        myResource.stop();
    }
}
