package hard;

/**
 * @author 李聪
 * @date 2020/2/14 9:32
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 */
public class T115_numDistinct {
    public static void main(String[] args) {

    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                //如果t的第i个字符和s的第j个字符相等
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    //dp[i-1][j-1]表示用这个字符，dp[i][j-1]表示不用s的这个字符
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
