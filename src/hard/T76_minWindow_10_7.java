package hard;

import java.util.HashMap;
import java.util.Map;

/** leetCode 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 *
 *     如果 S 中不存这样的子串，则返回空字符串 ""。
 *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class T76_minWindow_10_7 {
    public static void main(String[] args) {
        T76_minWindow_10_7 test = new T76_minWindow_10_7();
        test.minWindow("a","aa");
    }
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int left = 0,right = 0;  //左指针，右指针
        int la = 0,ra = -1;       //最小窗口的左右边界
        int min = Integer.MAX_VALUE;  //最小窗口的长度
        while(right < s.length()) {
            char cr = s.charAt(right);
            //如果map包含当前字母
            if(map.containsKey(cr)) {       //如果字典中包含当前字符
                //当前字母的个数-1
                map.put(cr,map.get(cr) - 1);
                while(match(map)) {              //如果窗口包含了t所有的字母
                     int len = right - left + 1;
                     if(len < min) {
                         min = len;
                         //更新左右窗口的最小边界
                         la = left;
                         ra = right;
                     }
                     char cl = s.charAt(left);   //获得左边的,将其恢复进行下一波
                    //恢复一波
                     if(map.containsKey(cl)) {
                         map.put(cl,map.get(cl) + 1);
                     }
                     left ++;
                }
            }
            right ++;
        }
        return s.substring(la,ra + 1);
    }

    private boolean match(Map<Character, Integer> map) {
        for (Character c : map.keySet()) {
            if(map.get(c) > 0) {
                return false;
            }
        }
        return true;
    }


}
