package medium2.threadlocal;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 李聪
 * @date 2020/3/9 10:36
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 *
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 *     线程 A 将调用 zero()，它只输出 0 。
 *     线程 B 将调用 even()，它只输出偶数。
 *     线程 C 将调用 odd()，它只输出奇数。
 *
 */
public class ZeroEvenOdd {
    private int n;
    public Semaphore z = new Semaphore(1);
    public Semaphore e = new Semaphore(0);
    public Semaphore o = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if((i & 1) == 0) {
                o.release();
            }else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
