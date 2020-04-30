package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/3/30 16:31
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 *关键是如何规划？转移方程是怎样的？
 * 我们知道3+1=4（余1）3+5=8（余2），4+3=7（余1），观察知道
 * 余数为0的数字+余数为0的数字余数为0
 * 余数为0的数字+余数为1的数字余数为1
 * 余数为0的数字+余数为2的数字余数为2
 *
 * 余数为1的数字+余数为0的数字余数为1
 * 余数为1的数字+余数为1的数字余数为2
 * 余数为1的数字+余数为2的数字余数为0
 *
 * 余数为2的数字+余数为0的数字余数为2
 * 余数为2的数字+余数为1的数字余数为0
 * 余数为2的数字+余数为2的数字余数为1
 *
 * 用max_0,1,2存着最大的这三种和。
 * 并不断更新即可。
 *
 */
public class T1262_可被三整除的最大和 {
    public static void main(String[] args) {

    }
    public int maxSumDivThree(int[] nums) {
        if(nums.length == 0)
            return 0;
        int temp = nums[0];
        int max_0 = 0;
        int max_1 = 0;
        int max_2 = 0;
        if(nums[0] % 3 == 0) {
            max_0 = temp;
        }else if(nums[0] % 3 == 1) {
            max_1 = temp;
        }else {
            max_2 = temp;
        }
        for(int i=1;i<nums.length;i++){
            int temp_max0=max_0;
            int temp_max1=max_1;
            int temp_max2=max_2;
            if(nums[i]%3==0){
                temp=nums[i]+temp_max0;
                max_0=Math.max(temp,temp_max0);
                if(temp_max1!=0){
                    temp=nums[i]+temp_max1;
                    max_1=Math.max(temp,temp_max1);}
                if(temp_max2!=0){
                    temp=nums[i]+temp_max2;
                    max_2=Math.max(temp_max2,temp);
                }
            } else if(nums[i]%3==1){
                temp=nums[i]+temp_max0;
                max_1=Math.max(temp,temp_max1);

                if(temp_max2!=0){

                    temp=nums[i]+temp_max2;
                    max_0=Math.max(temp,temp_max0);
                }
                if(temp_max1!=0){
                    temp=nums[i]+temp_max1;

                    max_2=Math.max(temp,temp_max2);
                }
            } else{
                temp=nums[i]+temp_max0;
                max_2=Math.max(temp,temp_max2);
                if(temp_max1!=0){
                    temp=nums[i]+temp_max1;
                    max_0=Math.max(temp,temp_max0);}
                if(temp_max2!=0){
                    temp=nums[i]+temp_max2;
                    max_1=Math.max(temp,temp_max1);
                }
            }
        }
        return max_0;


     }
}
