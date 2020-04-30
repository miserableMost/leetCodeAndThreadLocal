package medium2;

/**
 * @author 李聪
 * @date 2020/4/29 18:22
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T494_目标和 {
    public static void main(String[] args) {

    }
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(Math.abs(s) > Math.abs(sum))
            return 0;
        int n = nums.length;
        int t = sum * 2 + 1;
        int[][] dp = new int[n][t];
        if(nums[0] == 0) {
            dp[0][sum] = 2;
        }else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[n - 1][sum + s];
    }
}
