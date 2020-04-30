package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 47 : 全排列||
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 */
public class T47_permuteUnique_8_29 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] isVisted;
    private int len;
    public static void main(String[] args) {

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        isVisted = new boolean[len];
        resPer(0,nums,new Stack<>());
        return res;
    }

    private void resPer(int curSize, int[] nums, Stack<Integer> stack) {
         if(curSize == len){
             res.add(new ArrayList<>(stack));
             return;
         }
        for (int i = 0; i < len; i++) {
            if(!isVisted[i]) {
                //isVisted[i-1]无论true还是false都是对的--重复的只使用一个
                // !表示前面的都没使用过，否则表示的前面的都使用过--顺序索引
                if(i > 0 && nums[i] == nums[i - 1] && !isVisted[i - 1]){
                    continue;
                }
                isVisted[i] = true;
                stack.add(nums[i]);
                resPer(curSize + 1,nums,stack);
                stack.pop();
                isVisted[i] = false;
            }
        }

    }
}
