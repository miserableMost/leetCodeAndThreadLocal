package medium2;

/**
 * @author 李聪
 * @date 2020/4/29 17:27
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 *
 * 输出:
 *
 * 4
 */
public class T516_最长回文子序列 {
    public static void main(String[] args) {

    }
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n - 1;i >= 0;i --) {
            dp[i][i] = 1;
            for(int j = i + 1;j < n;j ++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
