package sort;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/22 9:03
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1,31,1,23,34,56,12,14};
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
         }
        System.out.println(Arrays.toString(nums));
    }
}
