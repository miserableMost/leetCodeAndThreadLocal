package Test.July;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 387: 字符串中第一个唯一字符
 */
public class Test387_firstUniqChar_29_REMEMBER {
    public static void main(String[] args) {

    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //存在c就放c对应的值，否则放0----记住
            res.put(c,res.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(res.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
