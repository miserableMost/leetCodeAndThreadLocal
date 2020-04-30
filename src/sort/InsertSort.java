package sort;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/22 9:08
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1,31,1,23,34,56,12,14};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
