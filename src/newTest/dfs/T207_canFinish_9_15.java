package newTest.dfs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 */
public class T207_canFinish_9_15 {
    public static void main(String[] args) {

    }
    //拓扑排序--判断有向图是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;
        if(prerequisites.length == 0)
            return true;
        //设置一个入度
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]] ++;
        }
        /*for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]] ++;
        }*/
        LinkedList<Integer> queue = new LinkedList<>();
        //入度为0的加入队列
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0)
                queue.addLast(i);
        }
        //定义一个结果集
        ArrayList<Integer> res = new ArrayList<>();
        while(! queue.isEmpty()) {
            Integer num = queue.poll();
            res.add(num);
            //可以用邻接表来操作
            //将与之相连的节点的度-1
            for (int[] p : prerequisites) {
                if(p[1] == num) {
                    inDegree[p[0]] --;
                    if(inDegree[p[0]] == 0)
                        queue.addLast(p[0]);
                }
            }

           /* for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == num) {
                    inDegree[prerequisites[i][0]] --;
                    if(inDegree[prerequisites[i][0]] == 0) {
                        queue.addLast(prerequisites[i][0]);
                    }
                }

            }*/

        }
        return res.size() == numCourses;
    }

}
