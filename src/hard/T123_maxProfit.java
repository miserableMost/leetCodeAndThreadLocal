package hard;

/**
 * @author 李聪
 * @date 2020/2/14 10:45
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class T123_maxProfit {
    public static void main(String[] args) {

    }
    //通用模板
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int maxK = 2,n = prices.length;
        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; i++) {
            //必须遍历建议次数k
            for (int k = maxK; k > 0 ; k--) {
                if(i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                //存在[k]中的状态是从k次交易的结果、k-1次交易的结果、k-2次交易的结果直到0次交易
                dp[i][k][0] = Math.max(dp[i - 1][k][0],dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1],dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }
    public int maxProfit2(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE,fstSell = 0;
        int secBuy = Integer.MIN_VALUE,secSell = 0;
        for (int p : prices) {
            fstBuy = Math.max(fstBuy,-p);  //第一次买与不买
            fstSell = Math.max(fstSell,fstBuy + p); //第一次卖与不卖
            secBuy = Math.max(secBuy,fstSell - p);   //第二次买与不买
            secSell = Math.max(secSell,secBuy + p);   //第二次卖与不卖
        }
        return  secSell;
    }
}
