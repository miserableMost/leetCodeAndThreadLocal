package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 22:19
 */
public class T66 {
    public int cutRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;  //记录最大的
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                res = Math.max(res,dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
