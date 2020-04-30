package medium2;

/**
 * leetCode 416: 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class T416_canPartition_10_8_dp {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean[] res = new boolean[sum + 1];
        res[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                //直接继承上一行(表示不加此数） 加上此数，则减
                res[i] = res[i] || res[i - num];
            }
        }

        return res[sum];

    }
}
