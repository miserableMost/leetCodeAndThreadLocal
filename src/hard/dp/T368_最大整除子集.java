package hard.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/4/10 21:48
 *
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 *
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 */
public class T368_最大整除子集 {
    public static void main(String[] args) {

    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
        int[] dp = new int[nums.length];
        //存储第i个元素的前驱元素
        int[] dp2 = new int[nums.length];
        //dp[i]数组存储前i个元素的最大整数子集
        Arrays.fill(dp,1);

        Arrays.fill(dp2,-1);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < dp[j] + 1) {
                        //这个元素可以加进去了
                        dp[i] = dp[j] + 1;
                        dp2[i] = j;
                    }
                }
            }
        }
        //找到长度最大的哪一个
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if(dp[i] > dp[index])
                index = i;
        }
        while(index != -1) {
            ans.add(nums[index]);
            index= dp2[index];
        }
        return ans;

    }
}
