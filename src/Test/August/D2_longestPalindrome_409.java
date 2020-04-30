package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 409:最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class D2_longestPalindrome_409 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        int count = 0;
        boolean flag = false;
        for (Character c : map.keySet()) {
            if(map.get(c) > 1){
                count += (map.get(c) / 2) * 2;
            }
            //检测是否存在奇数个数的字符
            if(map.get(c) % 2 != 0){
                flag = true;
            }
        }
        if(flag)
            count += 1;
        return count;
    }
}
