package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 46 : 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class T46_permute_8_29 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] isVisted;
    private int len;
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        T46_permute_8_29 test = new T46_permute_8_29();
        List<List<Integer>> lists = test.permute(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    // curSize 表示当前的路径 path 里面有多少个元素
    public List<List<Integer>> permute(int[] nums) {
          if(nums == null || nums.length == 0){
              return res;
          }
          len = nums.length;
          //由于无序，因而必须有数组标记是否访问过
          isVisted = new boolean[len];
          resPer(0,nums,new Stack<>());
          return res;

    }
    public void resPer(int curSize, int[] nums, Stack<Integer> stack){
        if(curSize == len){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!isVisted[i]){
                stack.push(nums[i]);
                isVisted[i] = true;
                resPer(curSize + 1,nums,stack);
                stack.pop();
                isVisted[i] = false;
            }

        }
    }
}
