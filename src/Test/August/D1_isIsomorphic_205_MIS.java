package Test.August;
/** leetCode 205:同构字符串
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 */

import java.util.HashMap;
import java.util.Map;

public class D1_isIsomorphic_205_MIS {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
    public static boolean isIsomorphic(String s, String t) {
         Map<Character,Character> res = new HashMap<>();
         int len = s.length();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            //如果不包含
            if(!res.containsKey(cs)){
                   //检查ct是否已经被映射过--关键
                   if(res.containsValue(ct))
                       return false;
                res.put(cs,ct);
            //如果包含
            }else{
                if(res.get(cs) != ct)
                    return false;
            }
        }
        return true;
    }
}
