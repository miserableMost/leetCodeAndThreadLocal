package medium.T398;

import java.util.Random;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 */
public class Solution {
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    //使用1/i 这个概率值选取第 i 个节点了。
    public int pick(int target) {
        Random r  = new Random();
        int res = 0;
        int flag = 0;
        for(int i = 0,size = nums.length;i < size;i ++) {
            if(nums[i] == target) {
                //记录有多少个满足的数
                flag ++;
                if(r.nextInt(flag) == 0) {
                    res = i;
                }
            }
        }
        return res;

    }
}
