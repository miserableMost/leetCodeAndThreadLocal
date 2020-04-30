package Test.August;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetCode 933:最近的请求次数
 * 写一个 RecentCounter 类来计算最近的请求。
 *
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 *
 * 返回从 3000 毫秒前到现在的 ping 数。
 *
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 *
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 */
public class D6_RecentCounter_933 {
    private Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) {

    }

    /**
     * 其实这题就是考的滑动窗口的概念，在TCP、限流、熔断的方案中，滑动窗口是个基本概念。
     *
     * 我的解法就是维护一个双向队列，该双向队列中维护了3000ms以内的时间。
     *
     * 一旦有新的ping请求进来，就根据ping的时间不断的从队列中取出时间差超过3000ms的元素，最后将当前ping请求的时间加到队列中即可。
     *
     * @param t
     * @return
     */
    public int ping(int t) {
        while (!queue.isEmpty()) {
            Integer tt = queue.removeFirst();
            if (t - 3000 <= tt) {
                queue.addFirst(tt);
                break;
            }
        }
        queue.add(t);
        return queue.size();


    }
}
