package medium2;

/**
 * @author 李聪
 * @date 2020/4/29 17:29
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *

 */
public class T416_分割等和子集 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        if(nums[0] <= sum)
            dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

}
