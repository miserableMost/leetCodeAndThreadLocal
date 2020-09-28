package findJob.first.singleton;

/**
 * 懒汉式：
 *  延迟创造这个对象
 *
 * 构造器私有化
 * 用一个静态变量保存这个唯一的实例
 * 提供一个静态方法，获取这个实例对象
 */
public class Singleton5 {
    private static volatile Singleton5 instance;
    private Singleton5() {

    }
    public static Singleton5 getInstance() {
        if(instance == null) {
            synchronized (Singleton5.class) {
                if(instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
