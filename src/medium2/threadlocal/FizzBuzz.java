package medium2.threadlocal;

import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * @author 李聪
 * @date 2020/3/9 11:27
 *
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 *     如果这个数字可以被 3 整除，输出 "fizz"。
 *     如果这个数字可以被 5 整除，输出 "buzz"。
 *     如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 *
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 *
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 *     线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 *     线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 *     线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 *     线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class FizzBuzz {
    private int n;
    private static CyclicBarrier barrier = new CyclicBarrier(4);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if((i % 3 == 0) && (i % 5 != 0)) {
                printFizz.run();
            }
            try{
                barrier.await();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if((i % 3 != 0) && (i % 5 == 0)) {
                printBuzz.run();
            }
            try{
                barrier.await();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                printFizzBuzz.run();
            }
            try{
                barrier.await();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if((i % 3 != 0) && (i % 5 != 0)) {
                printNumber.accept(i);
            }
            try{
                barrier.await();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}
