package hard;

/**
 * @author 李聪
 * @date 2020/2/14 15:43
 */
public class T188_maxProfit {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        //int i = maxProfit(2, prices);
       // System.out.println(i);
    }
    public  int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if(n <= 1)
            return 0;
        //超出内存限制
        if(k >= n/2) {
            int sum = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if(prices[i] < prices[i + 1])
                    sum += prices[i + 1] - prices[i];
            }
            return sum;
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
    /*private int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }*/



}
