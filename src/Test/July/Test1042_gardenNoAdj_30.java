package Test.July;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetCode 1042: 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 */
public class Test1042_gardenNoAdj_30 {
    public static void main(String[] args) {

    }
    //一个节点的度最多为3，若为4则证明必有一路径相通的花种植相同，与题意不符
    public int[] gardenNoAdj(int N, int[][] paths) {
         int[] answer = new int[N];
         //定义一个hash表，存储每个花园的可通路径
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            //初始化
            graph.put(i,new HashSet<>());
        }
        for (int[] path : paths) {
            //双向绑定
           graph.get(path[0] - 1).add(path[1] - 1);
           graph.get(path[1] - 1).add(path[0] - 1);
        }
        for (int i = 0; i < N; i++) {
            //定义一个数组判定是否用过
            boolean[] used = new boolean[5];
            //获取这个花园相通的花园p
            for (Integer p : graph.get(i)) {
                //answer[p]表示返回结果的第p个花园所种的花的种类--若没种则置0，这就是used为5的来历
                used[answer[p]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                //贪心算法
                if(!used[j])
                    answer[i] = j;
            }
        }
        return answer;


    }
}
