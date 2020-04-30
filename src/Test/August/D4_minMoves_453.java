package Test.August;

/**
 * leetCode 453: 最小移动次数使数组元素相等
 *给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1
 */
public class D4_minMoves_453 {
    public static void main(String[] args) {

    }
    //题意可理解位每次让一个值减去1，使得所有的值相等，那理想情况就是每个值最终等于最小值。 那么题目就转换为所有值减去最小值的和。
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
        }
        int count  = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - min;
        }
        return count;

    }
}
