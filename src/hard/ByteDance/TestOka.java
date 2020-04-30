package hard.ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/4/5 21:11
 */
public class TestOka {
    public static void main(String[] args) {
        TestOka oka = new TestOka();
        int[] num = {6,2,1};
        List<List<Integer>> subsets = oka.subsets(num);
        for (List<Integer> subset : subsets) {
            for (Integer i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
