package sort;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/22 9:00
 */
public class BubleSort {
    public static void main(String[] args) {
        int[] nums = {3,2,1,4,756,2,1,3};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
