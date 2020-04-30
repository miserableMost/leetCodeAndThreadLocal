package medium;

import java.util.concurrent.TimeUnit;

/**
 * @author 李聪
 * @date 2019/12/17 16:26
 */
public class Test {
    public Test() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    public static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }
    private static Object op1 = new Object();
    private static Object op2 = new Object();
    public static void main(String[] args) {

      /*  T1 test = new T1();
        T1.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--*/
        new Thread(() -> {
            synchronized (op1) {
                System.out.println(Thread.currentThread().getName() + "get Resouces1");
                //暂停一会线程
                try{
                    TimeUnit.SECONDS.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println("想要拿线程2");
                synchronized (op2) {
                    System.out.println(Thread.currentThread().getName() + "get Resouces2");
                }
            }
        },"s1").start();
        new Thread(() -> {
            synchronized (op2) {
                System.out.println(Thread.currentThread().getName() + "get Resouces2");
                //暂停一会线程
                try{
                    TimeUnit.SECONDS.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println("想要拿线程1");
                synchronized (op1) {
                    System.out.println(Thread.currentThread().getName() + "get Resouces1");
                }
            }
        },"s2").start();
    }
}