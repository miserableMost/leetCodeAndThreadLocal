package newTest.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 */
public class T209_minSubArrayLen_9_23 {
    public static void main(String[] args) {

    }
    //滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(i < nums.length) {
            if(sum + nums[i] < s) {
                sum += nums[i];
                i ++;
            }else {
                minLen = Math.min(minLen,i - start + 1);
                sum -= nums[start];
                start ++;
            }
        }
        //不存在符合条件的就返回0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
