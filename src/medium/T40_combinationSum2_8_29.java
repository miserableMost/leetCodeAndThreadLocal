package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 40 ： 组合总和 ||
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 */
public class T40_combinationSum2_8_29 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;
    public static void main(String[] args) {
        T40_combinationSum2_8_29 t4 = new T40_combinationSum2_8_29();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = t4.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          int len = candidates.length;
          if(len == 0){
              return res;
          }
          Arrays.sort(candidates);
          this.candidates = candidates;
          this.len = len;
          findConbina(target,0,new Stack<>());
          return res;
    }
    public void findConbina(int residue, int start, Stack<Integer> pre){
        if(residue < 0)
            return;
        if(residue == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }

            // 相同部分剪枝--此数组中有重复
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            pre.add(candidates[i]);
            findConbina(residue - candidates[i],i + 1,pre);
            pre.pop();
        }
    }
}
