package medium;

import java.util.Arrays;

/**
 * leetCode 324.摆动排序
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 *
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 *
 */
public class Test324_wiggleSort_10_20 {
    public static void main(String[] args) {
        int[] nums= {1,3,2,2,3,1};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void wiggleSort(int[] nums) {


        int len = nums.length;
        int[] bak = Arrays.copyOf(nums, len);
        Arrays.sort(bak);
        int sStart = (len+1)/2; //此时在中间的后一个数
        int bStart = len - 1;
        sStart--;  //aStart永远指向正确
        for (int i = 0; i < len / 2; i++) {
            nums[2 * i] = bak[sStart--];
            nums[2 * i + 1] = bak[bStart--];

        }
        // 处理len(small) - len (big)=1;
        //奇数的话单独处理
        if (len % 2 != 0) {
            nums[len - 1] = bak[0];
        }

    }
}
