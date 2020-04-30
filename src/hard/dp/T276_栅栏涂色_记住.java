package hard.dp;

/**
 * @author 李聪
 * @date 2020/4/10 17:51
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 *
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。
 *
 * 注意:
 * n 和 k 均为非负的整数。
 *
 * 示例:
 *
 */
public class T276_栅栏涂色_记住 {
    public static void main(String[] args) {

    }
    public int numWays(int n, int k) {
        if(n == 0 || k == 0)
            return 0;
        int[][] dp = new int[n][2];
        //dp[i][0]表示跟上一个柱子颜色相同的个数
        dp[0][0] = 0;
        //dp[i][1]表示跟上一个柱子颜色不同的个数
        dp[0][1] = k;
        for (int i = 1; i < n; i++) {
            //只能选择上一个颜色不同--因为最多两个颜色相同
            dp[i][0] = dp[i - 1][1];
            //选择上一个跟上上一个颜色相同或者不同
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];

    }
}
