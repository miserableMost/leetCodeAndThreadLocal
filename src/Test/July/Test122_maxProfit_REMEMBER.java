package Test.July;

/**
 * leetCode 122:买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候
 * 卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）
 *      的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

 */
public class Test122_maxProfit_REMEMBER {
    public static void main(String[] args) {

    }


    //峰谷法
    //在上述情况下，如果我们跳过 peakipeak_ipeaki​ 和 valleyjvalley_jvalleyj​ 试图通过考虑差异较大的点以获取更多的利润
    // 获得的净利润总是会小与包含它们而获得的静利润，因为 CCC 总是小于 A+BA+BA+B。
    //

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < length; i++) {
            if(prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
