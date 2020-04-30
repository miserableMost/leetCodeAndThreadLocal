package medium;

import java.util.*;

/**
 * leetCode 49 : 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class T49_groupAnagrams_8_16 {
    public static void main(String[] args) {

    }
    //维护一个映射 ans : {String -> List}，其中每个键 K\text{K}K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K\text{K}K。

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //先将其转为有顺序的相同的
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            //如果不存在这个索引，就加入
            if(!map.containsKey(s))
                map.put(s,new ArrayList<>());
            //往其中添加
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
     }
}
