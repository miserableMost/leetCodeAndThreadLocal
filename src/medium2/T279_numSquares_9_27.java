package medium2;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9
 *
 */
public class T279_numSquares_9_27 {
    public static void main(String[] args) {

    }
    // //四方定理：任何一个 自然数都可以用至多 四个数的平方来表示。  那么这道题就是变成了判断到底是用几个数表示
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            // 我们知道数字i可以由dp[i]个完全平方数组成。k*k表示一个完全平方数
            // 我们尝试着，数字i是否可以由dp[i-k*k]+1个完全平方数组成。
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
             }
        }
        return dp[n];
    }
}
