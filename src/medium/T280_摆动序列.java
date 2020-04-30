package medium;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/14 22:00
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 *
 * 示例:
 *
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 *
 */
public class T280_摆动序列 {
    public static void main(String[] args) {
        int[] nums = {3,5,2,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void wiggleSort(int[] nums) {
        boolean more = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if(more) {
                if(nums[i] < nums[i + 1]) {
                    swap(nums,i,i + 1);
                }
            }else {
                if(nums[i] > nums[i + 1]) {
                    swap(nums,i,i + 1);
                }
            }
            more = !more;
        }
    }
    private static void swap(int[] nums,int i,int j) {
        nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
    }
}
