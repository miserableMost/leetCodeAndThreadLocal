package Test.August;

/**
 * leetCode 674: 最长连续递增序列
 */
public class D2_findLengthOfLCIS_674 {
    public static void main(String[] args) {
         int[] nums = {1,3,5,7};
         int lengthOfLCIS = findLengthOfLCIS(nums);
         System.out.println(lengthOfLCIS);
    }
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
         int count = 1;
         int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                count ++;
            }else{
                //出现不递增时，立马跟之前的最大递增长度比较，并且将长度重新置1
                res = Math.max(count,res);
                count = 1;
            }

        }
        return res;
    }
}
