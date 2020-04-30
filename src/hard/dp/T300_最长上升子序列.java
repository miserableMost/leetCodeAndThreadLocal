package hard.dp;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/14 20:14
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class T300_最长上升子序列 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(nums.length < 2)
            return len;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
