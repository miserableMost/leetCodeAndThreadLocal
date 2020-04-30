package newTest.dfs;

/**
 * @author 李聪
 * @date 2020/3/14 22:32
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 0)
            return new int[0];
        //创建一个邻接表
        HashSet<Integer>[] graph = new HashSet[numCourses];
        //初始化graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        //创建一个入度
        int[] inDegree = new int[numCourses];
        //初始化
        for (int[] p : prerequisites) {
            //入度初始化
            inDegree[p[0]] ++;
            //邻接表初始化
            graph[p[1]].add(p[0]);
        }
        //定义一个队列
        LinkedList<Integer> queue = new LinkedList<>();
        //将入度为0的数字加入队列
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        //定义一个返回结果
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.pop();
            res.add(cur);
            //找到临接的课程
            for (Integer i : graph[cur]) {
                if(--inDegree[i] == 0)
                    queue.add(i);
            }
        }
        //如果搞定了
        if(res.size() == numCourses) {
            return res.stream().mapToInt(Integer::intValue).toArray();
        }else {
            return new int[0];
        }

    }
}
