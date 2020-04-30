package hard.ByteDance;

import java.util.PriorityQueue;

/**
 * @author 李聪
 * @date 2020/3/29 20:17
 * 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 *
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 *
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 *
 * 示例 2：
 *
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：我们无法抵达目的地，甚至无法到达第一个加油站。
 *
 * 示例 3：
 *
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 *
 *
 */
public class T871_最低加油次数 {
    public static void main(String[] args) {

    }

    /**
     * 想象成不是只在加油站才能加油，而是只要现在需要油，并且之前有加油站
     *
     * 还没有加油，那么此时就可以加油。这样一来，如果要使得加油次数最少，那么
     *
     * 只要加油就加最多的油，为了保证时间效率，这里用堆来维护前面的未用过的加油站
     *
     * 里的油量。需要加油而没有油时(也就是堆为空)，那么就不能够到达，此时返回-1。
     *
     * 这一题就是贪心+优先队列。
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    //dp[i] 为加 i 次油能走的最远距离，需要满足 dp[i] >= target 的最小 i。
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(stations == null)
            return startFuel >= target ? 0 : 1;
        //创建一个大顶堆,维护未使用过的加油站
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o2 - o1);
        int sum = startFuel;   //计算当前的燃料
        int ans = 0;            //返回结果
        for (int i = 0; i < stations.length; i++) {
            while(sum < stations[i][0]) {   //当前燃料无法达到
                Integer addOil = queue.poll();
                if(addOil == null)
                    return -1;
                sum += addOil;
                ans ++;
            }
            queue.offer(stations[i][1]);
        }
        while(sum < target) {
           Integer addOil = queue.poll();
           if(addOil == null)
               return -1;
           sum += addOil;
           ans ++;
        }
        return ans;
       /* int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;*/
    }
}
