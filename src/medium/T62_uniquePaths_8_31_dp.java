package medium;

/**
 * leetCode 62:不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class T62_uniquePaths_8_31_dp {
    public static void main(String[] args) {

    }
    //我们令 dp[i][j] 是到达 i, j 最多路径
    //
    //动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
    //
    //注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
    //

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //将dp初始化，最上和最左只有一条路
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
}
