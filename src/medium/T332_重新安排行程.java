package medium;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/14 19:06
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 *
 *     如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 *     所有的机场都用三个大写字母表示（机场代码）。
 *     假定所有机票至少存在一种合理的行程。
 *
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后.
 */
public class T332_重新安排行程 {
    public static void main(String[] args) {

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        if(tickets == null || tickets.size() == 0)
            return ans;
        Map<String,List<String>> graph = new HashMap<>();
        //构建邻接表
        for (List<String> t : tickets) {
            List<String> nbr = graph.computeIfAbsent(t.get(0),k -> new LinkedList<>());
            nbr.add(t.get(1));
        }
        //进行排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph,"JFK",ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while(nbr != null && nbr.size() > 0) {
            String next = nbr.remove(0);  //总是移出第一个、、因为已排序
            visit(graph,next,ans);
        }
        ans.add(0,src);
    }

}
