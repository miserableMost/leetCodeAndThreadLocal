package hard;
/**
 * leetCode 30 : 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T30_findSubstring_10_29 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        findSubstring(s,words);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int left = 0,right = 0,len = 0;
        List<Integer> res = new ArrayList<>();  //定义返回结果
        //所有单词数
        int size = words.length;
        if(words.length == 0)
            return res;
        else
            len = words[0].length();
        //存目标单词
        Map<String,Integer> needs = new HashMap<>();
        //存滑动窗口
        Map<String,Integer> windows = new HashMap<>();
        //初始化目标集合
        for (String word : words) {
            needs.put(word,needs.getOrDefault(word,0) + 1);
        }
        //单词匹配数量
        int match = 0;
        for (int i = 0;i < len ;i ++) {
            right = left = i;
            match = 0;
            //右指针能到达的最后位置
            while(right <= s.length() - len) {
                String s1 = s.substring(right,right + len);
                //以单词长度为步长
                right += len;
                //存入窗口中
                windows.put(s1,windows.getOrDefault(s1,0) + 1);
                //如果单词和出现的次数和目标一致，则匹配+1
                if(needs.containsKey(s1) && needs.get(s1).intValue() == windows.get(s1).intValue()) {
                    match ++;
                }
                //此时windows中已包含needs，但必须筛选达到里面必须只能有needs(windows中可能有多余的)
                //当匹配满足时
                while(left < right && match == needs.size()) {
                    //求出窗口中单词数--此时right已经增加
                    if((right - left) / len == size) {  //必须是连续满足--且必须去掉左边不满足的
                        res.add(left);
                    }
                    //左指针右移并消除左边的影响
                    String s2 = s.substring(left,left + len);
                    left += len;
                    windows.put(s2,windows.get(s2) - 1);
                    //因为此时windows已经移除了这个实际效果是小于等于
                    //当windows>needs时，即使去掉match也没有变
                    if (needs.containsKey(s2) && windows.get(s2).intValue() < needs.get(s2).intValue()){
                        match --;
                    }
                }

            }
            // 清空窗口，进行下一次遍历
            windows.clear();
        }
        return res;
    }
}
