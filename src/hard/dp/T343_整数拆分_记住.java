package hard.dp;

/**
 * @author 李聪
 * @date 2020/4/10 19:41
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 */
public class T343_整数拆分_记住 {
    public static void main(String[] args) {

    }
    //当我们考虑一个数的拆分情况时，只需要考虑一个数被两个数相加的情况就可了，
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 3;
        ////从4开始以后的每一个数，其通过拆分得到的积都大于其本身，不要问我为什么，猜的
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[1] * dp[i - 1];
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i],dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

}
