package hard;

/**
 * leetCode 312 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 *     你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 */
public class T312_maxCoins_10_7_dp {
    public static void main(String[] args) {

    }
    public int maxCoins(int[] nums) {
       int[][] dp = new int[nums.length + 2][nums.length + 2];
       //左右加1
        int[] newNums = new int[nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        //i->j
        for (int j = 2;j < newNums.length;j ++) {
            //遍历所有的可能性，0-2...0-n,1-3...1-n,...
            for (int i = 0; i < newNums.length - j; i++) {
                for (int k = i + 1; k < i + j; k++) {
                     dp[i][i + j] = Math.max(dp[i][i + j],dp[i][k]+dp[k][i + j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }
        return dp[0][newNums.length - 1];

    }
}
