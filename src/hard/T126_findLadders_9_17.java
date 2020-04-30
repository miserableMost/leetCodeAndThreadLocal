package hard;

import java.util.*;

/**
 *给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 *     每次转换只能改变一个字母。
 *     转换过程中的中间单词必须是字典中的单词。
 *
 * 说明:
 *
 *     如果不存在这样的转换序列，返回一个空列表。
 *     所有单词具有相同的长度。
 *     所有单词只由小写字母组成。
 *     字典中不存在重复的单词。
 *     你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 */
public class T126_findLadders_9_17 {
    public static void main(String[] args) {

    }
    //使用bfs
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord,endWord,wordList,ans);
        return ans;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        //将头添加到节点去
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            //上一层的结果队列
            int size = queue.size();
            //设置一波存储已经访问的
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> p = queue.poll();
                //得到当前路径的末位单词
                String temp = p.get(p.size() - 1);
                //一次性得到所有的节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        //到达结束单词，查询截止到该层
                        if(neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<>(p));
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        p.add(neighbor);
                        //将该路径添加到该层队列中
                        queue.offer(new ArrayList<>(p));
                        //移除这一个邻居，操作下一个邻居
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            //层次遍历--一旦这一层符合,便不再进行下一轮遍历--最短路径
            if(isFound) {
                break;
            }
         }

    }
    private ArrayList<String> getNeighbors(String nodes, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = nodes.toCharArray();
        for(char ch = 'a';ch <= 'z';ch ++) {
            for (int i = 0; i < chs.length; i++) {
                if(chs[i] == ch) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                if(dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }
}
