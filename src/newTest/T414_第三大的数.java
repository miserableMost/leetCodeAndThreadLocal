package newTest;

/**
 * @author 李聪
 * @date 2020/4/21 9:42
 */
public class T414_第三大的数 {
    public static void main(String[] args) {
        int[] nums = {5,2,2};
        int i = thirdMax(nums);
        System.out.println(i);
    }
    public static int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE && flag) {
                flag = false;
                count ++;
            }
            if(nums[i] > max) {
                count ++;
                third = sec;
                sec = max;
                max = nums[i];
            }else if(nums[i] < max && nums[i] > sec) {
               third = sec;
               sec = nums[i];
               count ++;
            }else if(nums[i] > third && nums[i] < sec) {
                third = nums[i];
                count ++;
            }
        }
        return count >= 3 ? third : max;
    }
}
