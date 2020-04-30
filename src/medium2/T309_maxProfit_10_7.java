package medium2;

/**
 * leetCode 309 : 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 */
public class T309_maxProfit_10_7 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
      /* int m = prices.length;
       if(m < 2)
           return 0;
       int[][] dp = new int[m][2];
        for (int i = 0; i < m; i++) {
            if(i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if(i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
                continue;
            }
            //解释：今天我没有持有股票，有两种可能：
            //要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
            //要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了
            //
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            //解释：今天我持有着股票，有两种可能：
            //要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
            //要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i]);
        }
        return dp[m - 1][0];*/
       int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
       int dp_pre_0 = 0;//代表dp[i-2][0]
        for (int i = 0; i < prices.length; i++) {
            //暂时存一波
            int temp = dp_i_0;
            //今天不持有股票
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            //今天持有股票
            dp_i_1 = Math.max(dp_i_1,dp_pre_0 - prices[i]);
            //更新一波dp[i-2][0]
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
