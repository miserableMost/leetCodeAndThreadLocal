package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/4/11 13:19
 *
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 *
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 *
 */
public class T159_至多包含两个不同字符的最长子串 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int l = 0,r = 0,ans = 2;
        Map<Character,Integer> map = new HashMap<>();
        while(r < s.length()) {
            char cur = s.charAt(r);
            //表示cur的后面位置
            if(map.size() < 3) {
                map.put(cur,r);
                r ++;
            }

            //当map中包含3个数时
            if(map.size() == 3) {
                //找到value最小的
                Integer idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                l = idx + 1;
            }
            ans = Math.max(ans,r - l);
        }
        return ans;
    }

}
