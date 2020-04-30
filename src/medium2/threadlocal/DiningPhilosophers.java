package medium2.threadlocal;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李聪
 * @date 2020/3/9 11:51
 *
 * 5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子）
 *
 * 所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。
 *
 * 假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。
 *
 * 设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。
 */
public class DiningPhilosophers {
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    private ReentrantLock[] locks = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};
    //限制最多只有四个哲学家
    private Semaphore eatNumber = new Semaphore(4);
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //计算出左右叉子的编号
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        //限制就餐人数-1
        eatNumber.acquire();
        //拿起左右的叉子
        locks[leftFork].lock();
        locks[rightFork].lock();
        //具体操作
        pickLeftFork.run();
        pickRightFork.run();
        //开始吃
        eat.run();
        //放下叉子具体操作
        putLeftFork.run();
        putRightFork.run();
        //放下叉子
        locks[leftFork].unlock();
        locks[rightFork].unlock();
        //增加就餐
        eatNumber.release();
     }
}
