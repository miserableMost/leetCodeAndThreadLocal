package Test.July;

/**
 * leetCode 121:买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 */
public class Test121_maxProfit_7_22 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    //买入的时候尽可能小，卖出的时候尽可能大
    /*public static int maxProfit(int[] prices) {
        int length = prices.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = prices[j] - prices[i];
                if(temp > res){
                    res = temp;
                }
            }
        }
        return res;
    }*/
    //找到最小的谷之后的最大的峰
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
