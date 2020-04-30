package medium2.threadlocal;

/**
 * @author 李聪
 * @date 2020/3/9 10:04
 *
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1:
 */
public class FooBar {
    private int n;
    private boolean fooTurn = true;
    private Object lock = new Object();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if(!fooTurn) {
                    lock.wait();
                }
                fooTurn = false;
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if(fooTurn) {
                   lock.wait();
                }
                fooTurn = true;
                printBar.run();
                lock.notifyAll();
            }

        }
    }
}
