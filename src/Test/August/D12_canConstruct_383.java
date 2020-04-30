package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 383:赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 */
public class D12_canConstruct_383 {
    public static void main(String[] args) {
         String r = "aa";
         String m = "aab";
        boolean b = canConstruct(r, m);
        System.out.println(b);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
         Map<Character,Integer> map = new HashMap<>();
         for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
         }
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            if(map.containsKey(r) && map.get(r) > 0){
                map.put(r,map.get(r) - 1);
            }else{
                return false;
            }
        }
        return true;

    }
}
