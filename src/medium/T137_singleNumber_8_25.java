package medium;

/**
 * leetCode 137 : 只出现一次的数字
 *
 */
public class T137_singleNumber_8_25 {
    public static void main(String[] args) {
         int[] nums = {2,1,1,2,1,99,99,99};
         singleNumber(nums);
    }
    public static int singleNumber(int[] nums) {
        int a = 0,b = 0;
        /*for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }*/
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }
        return a;
    }
}
