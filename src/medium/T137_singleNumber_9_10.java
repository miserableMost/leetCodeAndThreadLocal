package medium;

/**
 * leetCode 137 : 只出现一次的数字 II
 *
 */
public class T137_singleNumber_9_10 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        singleNumber(nums);
    }
    public static int singleNumber(int[] nums) {
        int[] bits = new int[32];
        //将每个数的每一位加起来
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j] >> i;
                bits[i] += num & 1;
            }
        }
        //bits是逆序存储的每个位之和--从后往前
        //将每一位除以3
        int result = 0;
        for (int i = 31; i >= 0 ; i--) {
            result <<= 1;
            result += bits[i] % 3;
        }
        return result;


    }
    /*public static int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        int result = 0;
        for (int i = 0; i < 32 ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                int num = nums[j] >> i;
                bits[i] += num & 1;
            }
            result <<= 1;
            result += bits[31 - i] % 3;

        }
        return result;
    }*/
}
