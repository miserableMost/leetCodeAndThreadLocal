package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 *
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 */
public class T228_summaryRanges_9_25 {
    public static void main(String[] args) {
        int[] nums = {0};
        List<String> strings = summaryRanges(nums);
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }
        if(nums.length == 1){
            ans.add(nums[0] + "");
            return ans;
        }
       int i = 0;
       int start = 0;
       while(i < nums.length - 1){
           i ++;
           if(nums[i] != nums[i - 1] + 1) {
               if(nums[start] == nums[i - 1]){
                   ans.add(nums[start]+ "");
               }else {
                   ans.add(nums[start] + "->" + nums[i - 1]);
               }
               start = i;
           }
       }
       //处理最后一个
       if(nums[i] != nums[i - 1] + 1) {
           ans.add(nums[i] + "");
       }else {
           ans.add(nums[start] + "->" + nums[i]);
       }
       return ans;

    }
}
