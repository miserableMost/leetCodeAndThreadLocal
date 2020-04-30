package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/4/11 14:38
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 *
 * 示例：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class T163_缺失的区间 {
    public static void main(String[] args) {
        List<String> missingRanges = findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
        for (String missingRange : missingRanges) {
            System.out.println(missingRange);
        }

    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            if(lower == upper)
                ans.add(lower + "");
            else
                ans.add(lower + "->" + upper);
            return ans;
        }

        //先定下查询的区间
        int start = -1,end = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] <=lower && nums[i] >= lower){
                start = i - 1;
            }
            if(nums[i - 1] <= upper && nums[i] >= upper) {
                end = i;
            }
        }

       if(lower + 1 == nums[start + 1]) {
            ans.add(lower + "");
        }else if(nums[start + 1] > lower + 1) {
            ans.add(lower + "->" + (nums[start] - 1));
        }

        for (int i = start + 1; i < end - 1; i++) {
            //如果相差为1
            if(nums[i] + 1 == nums[i + 1])
                continue;
            //如果相差为2
            if(nums[i] + 2 == nums[i + 1])
                ans.add(nums[i] + 1 + "");
            else
                ans.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
        }
        if(nums[end - 1] == upper) {

            return ans;
        }else if(nums[end - 1] + 1 == upper){
            ans.add(upper + "");
        }else {
            ans.add((nums[end - 1] + 1) + "->" + (upper));
        }

        return ans;
    }
}
