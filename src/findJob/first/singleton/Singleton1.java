package findJob.first.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**饿汉式：
 *   直接创建实例对象，不管你是否需要这个对象
 * 1.私有化构造器
 * 2.自行创建，并且用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {

    public static void main(String[] args) {
        new ConcurrentHashMap<>();
    }
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() {

    }
}
