package Test.July;

import java.util.Arrays;

/**
 * leetCode 242 :有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class Test242_isAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chart = t.toCharArray();
        Arrays.sort(chart);
        if (Arrays.equals(chars,chart)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)-'a'] ++;
            temp[t.charAt(i)-'a'] --;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]!=0){
                return false;
            }
        }

        return true;
    }
}
