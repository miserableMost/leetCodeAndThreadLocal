package medium;
/**
 * leetCode 90 : 子集
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90_subsetsWithDup_9_5 {
    public static void main(String[] args) {
        T90_subsetsWithDup_9_5 test = new T90_subsetsWithDup_9_5();
        int[] nums = {1,2,2};
        List<List<Integer>> lists = test.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<>());
        return res;


    }

    public void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            backtrack(i + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }



}
