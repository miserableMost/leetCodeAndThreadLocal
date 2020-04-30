package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 819 : 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 */
public class D4_mostCommonWord_819_REMEMBER {
    public static void main(String[] args) {
        String ps = "Bob!";
        String[] banned = {"hit"};
        String s = mostommonWord(ps, banned);
        System.out.println(s);
    }
    public static String mostommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Map<String,Integer> map = new HashMap<>();
        // 将单词串转化成单词数组
        String[] strArr = paragraph.split("\\b");
        for (String str : strArr) {
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        //将禁止使用的放入map2中
        Map<String,Integer> map2 = new HashMap<>();
        for (String s : banned) {
            map2.put(s,map2.getOrDefault(s,0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String sb = "";
        for (String s : map.keySet()) {
            //只有当字符为字母时才进行运算
            if(s != null && s.length() != 0 && (s.charAt(0) >= 'a' && s.charAt(0) <= 'z')){
                if(!map2.containsKey(s)){
                    if(map.get(s) > max){
                        sb = s;
                        max = map.get(s);
                    }

                }
            }

        }
        return sb;

    }
}
