package findJob.first.singleton;

/**
 * 懒汉式：
 *  延迟创造这个对象
 *
 * 构造器私有化
 * 用一个静态变量保存这个唯一的实例
 * 提供一个静态方法，获取这个实例对象
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4() {

    }
    public static Singleton4 getInstance() {
        if(instance == null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Singleton4();
        }
        return instance;
    }
}
