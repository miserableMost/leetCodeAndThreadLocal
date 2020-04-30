package Test.April;

/**leetCode:746. 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class Test746_minCostClimbingStairs {

    public static void main(String[] args) {
        Test746_minCostClimbingStairs test = new Test746_minCostClimbingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(test.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        //每次爬 i 个楼梯，计算的都是从倒数第一个结束，还是从倒数第二个结束，由此可以总结动态转移方程为
        //minCost[i] = Math.min(minCost[i-2]+cost[i-2],minCost[i-1]+cost[i-1]);
        //minCost表示爬到第i级阶梯需要的力气
        //这里把cost[i]理解为这一层到达下一层或两层需要花的力气
        //因而minCost表示必须比cost大一级，代表爬完阶梯
        //int[] minCost = new int[cost.length+1];
       /* minCost[0] = 0;
        minCost[1] = 0;
        for(int i=2;i<minCost.length;i++){
            minCost[i] = Math.min(minCost[i-2]+cost[i-2],minCost[i-1]+cost[i-1]);
        }
        return minCost[minCost.length-1];*/
        //如果把cost理解为上一层或两层爬到这一层需要的花费
        //爬到最后一层或倒数第二层时视为爬完,此时需要比较最后第一层和倒数第二层
        int[] minCost = new int[cost.length];
        int min = 0;
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            minCost[i] = Math.min(minCost[i-1],minCost[i-2])+cost[i];
        }
        min = Math.min(minCost[cost.length-1],minCost[cost.length-2]);
        return min;

    }
}
