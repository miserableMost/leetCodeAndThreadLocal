package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 78:子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class T78_subsets_8_25 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        T78_subsets_8_25 test = new T78_subsets_8_25();
        test.subsets(nums);
    }
    //从前往后遍历, 遇到一个数, 之前的所有集合添加上这个数组成新的子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                //给每个集合都添加当前数，并形成新的集合
                temp.add(nums[i]);
                res.add(temp);
             }
        }
        return res;
    }
}
