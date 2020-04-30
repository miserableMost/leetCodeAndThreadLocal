package findJob.second.JUC;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 李聪
 * @date 2020/1/21 14:57
 * 到齐了再开会
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("****召唤神龙");
        });
        for(int i = 1;i <= 7;i ++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 号龙珠收集到了");
                try{
                    cyclicBarrier.await();

                }catch(Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
