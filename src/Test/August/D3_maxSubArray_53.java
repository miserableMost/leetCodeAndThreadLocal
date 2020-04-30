package Test.August;

/**
 * leetCode 53 :最大子序列和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class D3_maxSubArray_53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            //如果前n项和为负数，显然不会是最大子序列和的开始
            sum = sum < 0? nums[i] : (sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;

    }
}
