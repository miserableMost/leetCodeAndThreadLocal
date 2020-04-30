package Test.August;

import java.util.Arrays;

/**
 * leetCode 283 :移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class D5_moveZeroes_283 {
    public static void main(String[] args) {
         int[] nums = {0,1,0,3,12};
         moveZeroes(nums);
    }
    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
          //计算非0的个数
        int count = 0;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0)
                nums[count ++] = nums[i];
        }
        //count已经++了哦
        for (int i = count; i < len; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
