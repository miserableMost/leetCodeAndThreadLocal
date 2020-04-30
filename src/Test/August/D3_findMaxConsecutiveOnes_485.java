package Test.August;

/**
 * leetCode 485 :最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class D3_findMaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int max = findMaxConsecutiveOnes(nums);
        System.out.println(max);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            //如果为1
            if(nums[i] == 1){
                count ++;
            //如果为0开始计时
            }else{
                res = Math.max(count,res);
                count = 0;
            }
        }
        return Math.max(res,count);
    }
}
