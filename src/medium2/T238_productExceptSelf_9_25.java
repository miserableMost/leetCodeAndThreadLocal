package medium2;

import java.util.Arrays;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */
public class T238_productExceptSelf_9_25 {
    public static void main(String[] args) {
         int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 因为空间复杂度要求 O(1)O(1)O(1)、不能使用除法，因此一定需要在乘法过程中得到所有答案；
     * 我们可以将res数组列成乘积形式，形成一个矩阵，可以发现矩阵次主角线全部为 111 （因为当前数字不相乘，因此等价为乘 111 ）；
     * 因此，我们分别计算矩阵的上三角和下三角，并且在计算过程中储存过程值，最终可以在遍历 222 遍nums下完成结果计算。
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        //计算上三角--对角线以下的数
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        //计算下三角--对角线以上的数
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= q;
            q *= nums[i];
           /* q *= nums[i];
            res[i - 1] *= q;*/
        }
        return res;
    }
}
