package medium;

import java.util.HashMap;
import java.util.Map;

/**leetCode 3 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public class T3_lengthOfLongestSubstring_10_14 {
    public static void main(String[] args) {
        String s = "abba";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
      /*  int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;*/
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                i  = Math.max(map.get(c) + 1,i);
            }
            //一定是在不重复时判断长度
            ans = Math.max(ans,j - i + 1);
            map.put(c,j);
            j ++;
        }
        return ans;



      /*  for (int i = 0,j = 0; i < s.length(); j++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {

            }
        }*/


    }
}