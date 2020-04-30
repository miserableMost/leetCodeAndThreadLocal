package designPattern.single;

/**
 * 单例模式---饿汉式
 */
public class Singleton {
    //在静态初始化器中创建单例实例
    private static Singleton uniqueInstance = new Singleton();
    //Singleton类只有一个构造方法并且是被private修饰的，所以用户无法通过new方法创建该对象实例
    private Singleton(){

    }
    public static Singleton getInstance(){
        return uniqueInstance;
    }

}
