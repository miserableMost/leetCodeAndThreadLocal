package medium;

import javafx.util.Pair;

import java.util.*;

/**
 * leetCode 127 : 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 *     每次转换只能改变一个字母。
 *     转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *     如果不存在这样的转换序列，返回 0。
 *     所有单词具有相同的长度。
 *     所有单词只由小写字母组成。
 *     字典中不存在重复的单词。
 *     你可以假设 beginWord 和 endWord 是非空的，且二者不相同
 */
public class T127_ladderLength_9_8 {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        T127_ladderLength_9_8 t = new T127_ladderLength_9_8();
        int i = t.ladderLength(begin, end, wordList);
        System.out.println(i);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 求最短路径问题，使用图的层次遍历（BFS）
        assert beginWord.length() == endWord.length();
        Set<String> visited = new HashSet<>();
        if (beginWord.equals(endWord)) return 1;
        if (!wordList.contains(endWord)) return 0;
        // 预先缓存
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                //没有就创建这个集合，有就直接获取
                List<String> list = map.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                map.put(newWord, list);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {

            Pair<String, Integer> poll = queue.poll();
            if (poll == null) continue;
            int level = poll.getValue();
            String word = poll.getKey();

            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!map.containsKey(newWord)) continue;
                List<String> list = map.get(newWord);
                for (String str : list) {
                    //已经达到最后一个
                    if (endWord.equals(str)) return level + 1;
                    //是否已经访问过
                    if (visited.contains(str)) continue;
                    visited.add(str);
                    queue.offer(new Pair<>(str, level + 1));
                }
            }
        }


        return 0;


    }


}
