package hard.ByteDance;

import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2020/4/9 22:30
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 *
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 */
public class T862_和至少为K的最短子数组 {
    public static void main(String[] args) {

    }
    public int shortestSubarray(int[] A, int K) {
        //新建一个前缀和
        int N = A.length;
        long[] p = new long[N + 1];
        for (int i = 0; i < N; i++) {
            p[i + 1] = p[i] + (long)A[i];
        }
        int ans = N + 1;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int y = 0; y < p.length; y++) {
            //保证queue单调递增
            while(!queue.isEmpty() && p[y] <= p[queue.getLast()]) {
                queue.removeLast();
            }

            while(!queue.isEmpty() && p[y] >= p[queue.getFirst()]  + K) {
                ans = Math.min(ans,y - queue.removeFirst());
            }
            queue.add(y);
        }
        return ans < N+1 ? ans : -1;
    }
}
