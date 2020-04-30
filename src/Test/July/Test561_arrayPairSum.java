package Test.July;

import java.util.Arrays;

/**
 * leetCode 561:数组拆分1
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
public class Test561_arrayPairSum {
    public static void main(String[] args) {
        int[] n = {1,2,2,4,5,6};
        arrayPairSum(n);
    }
    //小的跟小的在一起，大的跟大的在一起，必然和最小
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i+=2) {
            sum += nums[i];
        }
        System.out.println(sum);
        return sum;
    }
}
