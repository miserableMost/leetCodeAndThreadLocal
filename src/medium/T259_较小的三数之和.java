package medium;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/11 18:30
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 * 示例：
 *
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 *
 * 进阶：是否能在 O(n2) 的时间复杂度内解决？
 *
 */
public class T259_较小的三数之和 {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int i = threeSumSmaller(nums, 2);
        System.out.println(i);
    }
    public static int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum >= target) {
                    //减去一个最小的看他大不大
                    r --;
                }else {
                    //加右边的小于他，右边的左边必然也小
                    ans += r - l;
                    l  ++;
                }
            }
        }
        return ans;
    }
}
