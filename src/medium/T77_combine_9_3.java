package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 77 : 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class T77_combine_9_3 {
    private List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        T77_combine_9_3 test = new T77_combine_9_3();
        List<List<Integer>> combine = test.combine(4, 2);
        for (List<Integer> list : combine) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        dfs(n,k,1,new Stack<>());

        return res;

    }
    //再如：如果 n = 6 ，k = 4，
    //pre.size() == 1 的时候，接下来要选择 3 个元素， i 最大的值是 4，最后一个被选的是 [4,5,6]；
    //pre.size() == 2 的时候，接下来要选择 2 个元素， i 最大的值是 5，最后一个被选的是 [5,6]；
    //pre.size() == 3 的时候，接下来要选择 1 个元素， i 最大的值是 6，最后一个被选的是 [6]；
    //
    //再如：如果 n = 15 ，k = 4，
    //pre.size() == 1 的时候，接下来要选择 3 个元素，i 最大的值是 13，最后一个被选的是 [13,14,15]；
    //pre.size() == 2 的时候，接下来要选择 2 个元素， i 最大的值是 14，最后一个被选的是 [14,15]；
    //pre.size() == 3 的时候，接下来要选择 1 个元素， i 最大的值是 15，最后一个被选的是 [15]；
    //
    public void dfs(int n,int k,int index,Stack<Integer> p){
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            dfs(n, k, i + 1, p);
            p.pop();
        }
    }
}
/*
class Solution3 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<>());
        return result;
    }

    // p 可以声明成一个栈
    // i 的极限值满足： n - i + 1 = (k - pre.size())。
    // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
    // k - pre.size() 是剩下还要寻找的数的个数。
    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            findCombinations(n, k, i + 1, p);
            p.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution3().combine(4, 2);
        System.out.println(lists);
    }
}
*/

