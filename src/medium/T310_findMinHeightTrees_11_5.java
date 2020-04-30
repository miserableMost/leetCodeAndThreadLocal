package medium;

import java.util.*;

/**
 * leetCode 310 : 最小高度树
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，
 * 具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 *
 */
public class T310_findMinHeightTrees_11_5 {
    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        //特殊情况
        if(n <= 2) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        //入度数组
        int[] inDegrees = new int[n];
        //默认为False,如果剔除，设置为true
        boolean[] result = new boolean[n];
        // 因为是无向图，所以邻接表拿出一条边，两个结点都要存一下
        // 注意：右边就不要写具体的实现类了，等到实例化的时候再写具体的实现类
        Set<Integer>[] adjs = new Set[n];
        //初始化
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjs[start].add(end);
            adjs[end].add(start);
            inDegrees[start] += 1;
            inDegrees[end] += 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        //入度为1的节点入队
        for (int i = 0; i < n; i++) {
            if(inDegrees[i] == 1)
                queue.addLast(i);
        }
        while(n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int top = queue.removeFirst();
                result[top] = true;
                inDegrees[top] -= 1;
                //把它和它的邻接节点的入度全部减1
                Set<Integer> successors = adjs[top];
                for (Integer successor : successors) {
                    inDegrees[successor] -= 1;
                    if(inDegrees[successor] == 1) {
                        queue.addLast(successor);
                    }
                }
            }
        }
        //返回结果
        n = result.length;
        for (int i = 0; i < n; i++) {
            if(!result[i])
                res.add(i);
        }
        return res;
    }
}
