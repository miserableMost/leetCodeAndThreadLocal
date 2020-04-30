package findJob.second.JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李聪
 * @date 2020/1/6 22:16
 */
class MyData {       //MyData.java ===> MyData.class ===> JVM字节码
    volatile int number = 0 ;
    public void addT060() {
        this.number = 60;
    }
    public void addPlusPlus() {
        number ++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证volatile的可见性
 * 1.1 假如int number = 0;number变量之前根本没有添加volatile关键字修饰,没有可见性
 * 1.2 添加了volatile可以解决可见性问题
 *
 * 2.验证volatile不保证原子性
 * 2.1 原子性指的是什么意思？
 *      不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整
 *      要么同时成功，要么同时失败。
 * 2.2 是否可以保证原子性的案例演示
 *
 * 2.3 why ?
 *  多个线程出现写覆盖
 *
 * 2.4  如何解决原子性问题
 *  *加sync
 *  * 使用我们的Juc下AtomicInteger
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {   //main是一切方法的运行入口
        MyData myData = new MyData();
        //数值少于20000，出现丢失写值的情况
       for(int i = 1;i <= 20;i ++) {
           new Thread(() -> {
               for (int j = 1; j <= 10000 ; j++) {
                   myData.addPlusPlus();
                   myData.addMyAtomic();
               }
           },String.valueOf(i)).start();
       }
       //需要等待上面20个线程全部计算完成后，再用main线程取得最终的结果值看是多少？
        while(Thread.activeCount() > 2) {   //main线程，后台jc线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type, finally number value: " + myData.atomicInteger);
    }
    //volatile可以保持可见性，及时通知其他线程，主物理内存及时修改
    /*public static void seeOkByVolatile() {
        MyData myData = new MyData();//资源类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停一会线程
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch(Exception e){
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName()+"\t update number value: " + myData.number);
        },"AAA").start();
        //第二个线程就是我们的main线程
        while(myData.number == 0) {
            //main线程就一直在这里等待循环，直到number不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get number value: " + myData.number);
    }*/
}
