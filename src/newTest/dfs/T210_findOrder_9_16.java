package newTest.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 */
public class T210_findOrder_9_16 {
    public static void main(String[] args) {

    }
    //判断有向图是否有环
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 0)
            return new int[0];
        //创建邻接表
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        //入度表
        int[] inDegree = new int[numCourses];
        //填上邻接表和入度表
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            inDegree[p[0]] ++;
        }
        //创建一个队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        //创建一个结果集
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            //弹出入度为0的
            Integer zero = queue.poll();
            //加入到结果集中
            res.add(zero);
            //得到后继课程，把他们全部入度-1
            HashSet<Integer> nextCourses = graph[zero];
            for (Integer nextCours : nextCourses) {
                inDegree[nextCours] --;
                if(inDegree[nextCours] == 0)
                    queue.add(nextCours);
            }
        }
        //如果结果集中的数量不等于节点的数量，就不可能完成任务
        int resLen = res.size();
        if(resLen == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }else {
            return new int[0];
        }
    }
}
