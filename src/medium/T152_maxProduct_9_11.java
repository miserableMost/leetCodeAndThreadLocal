package medium;

/**
 * leetCode 152 : 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 */
public class T152_maxProduct_9_11 {
    public static void main(String[] args) {
        int[] maxPro = {2,3,-2,4};
        int i = maxProduct(maxPro);
        System.out.println(i);
    }
    //“由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cmax = 1;
        int cmin = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = cmax;
                cmax = cmin;
                cmin = temp;
            }
            //维持一个最大值
            cmax = Math.max(cmax * nums[i],nums[i]);
            //维持一个最小值
            cmin = Math.min(cmin * nums[i],nums[i]);
            max = Math.max(max,cmax);
        }
        return max;

    }
}
