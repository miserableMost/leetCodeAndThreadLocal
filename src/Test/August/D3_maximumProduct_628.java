package Test.August;

import java.util.Arrays;

public class D3_maximumProduct_628 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,3,4,4};
        int i = maximumProduct(nums);
        System.out.println(i);
    }
    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len == 3)
            return nums[0] * nums[1] * nums[2];
        Arrays.sort(nums);
        int res = nums[len - 1] * nums[len - 2] * nums[len - 3];
        if(nums[0] < 0 && nums[1] < 0  && nums[len - 1] >= 0){    //如果至少有两个负数并且一定有个非负数
                return Math.max(nums[0] * nums[1] * nums[len - 1],res);
        }else{
            return res;
        }
    }
}
