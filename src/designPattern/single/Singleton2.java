package designPattern.single;

/**
 * 单例模式2--懒汉式
 */
public class Singleton2 {
    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private  volatile static Singleton2 uniqueInstance;
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        //检查实例，如果不存在，就进入同步代码块
        if(uniqueInstance == null){
            //只有第一次才彻底执行这里的代码
            synchronized (Singleton2.class){
                //进入同步代码块后，再检查一次，如果仍是null,再创建
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton2();
                }
            }

        }
        return uniqueInstance;
    }
}
