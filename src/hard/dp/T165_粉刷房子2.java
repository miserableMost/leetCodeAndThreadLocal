package hard.dp;

/**
 * @author 李聪
 * @date 2020/4/10 17:19
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * 注意：
 *
 * 所有花费均为正整数。
 *
 * 示例：
 *
 * 输入: [[1,5,3],[2,9,4]]
 * 输出: 5
 * 解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5;
 *      或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5.
 *
 */
public class T165_粉刷房子2 {
    public static void main(String[] args) {
        int[][] nums = {{1,5,3},{2,9,4}};
        int i = minCostII(nums);
        System.out.println(i);
    }
    public static int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if(l == j)
                        continue;
                    min = Math.min(dp[i - 1][l],min);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(dp[n - 1][i],ans);
        }
        return ans;
    }
}
