package medium;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/2/28 22:01
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class T16_threeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        T16_threeSumClosest test = new T16_threeSumClosest();
        int i = test.threeSumClosest(nums, -1);
        System.out.println(i);
    }
    // 对Integer.MAX_VALUE取Math.abs是无效的

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            throw new RuntimeException("输入非法");
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println(Math.abs(ans - target));
                if(Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if(sum > target) {
                    right --;
                }else if(sum < target) {
                    left ++;
                }else {
                    return target;
                }
            }
        }
        return ans;
    }
}
