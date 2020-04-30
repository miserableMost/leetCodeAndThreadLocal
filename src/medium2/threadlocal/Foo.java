package medium2.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @author 李聪
 * @date 2020/3/9 9:09
 *
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 *
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 *     线程 A 将会调用 one() 方法
 *     线程 B 将会调用 two() 方法
 *     线程 C 将会调用 three() 方法
 *
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行
 */
public class Foo {

    public CountDownLatch first_second = new CountDownLatch(1);
    public CountDownLatch second_third = new CountDownLatch(1);
    public Foo() {

    }
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first_second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first_second.await();
        printSecond.run();
        second_third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second_third.await();
        printThird.run();
    }
}
