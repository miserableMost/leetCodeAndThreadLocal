package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/4/8 23:13
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 *     任何左括号 ( 必须有相应的右括号 )。
 *     任何右括号 ) 必须有相应的左括号 ( 。
 *     左括号 ( 必须在对应的右括号之前 )。
 *     * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *     一个空字符串也被视为有效字符串。
 *
 */
public class T678_有效的括号字符串 {
    public static void main(String[] args) {

    }
    public boolean checkValidString(String s) {
        //不断更新左括号的区间
        int lo = 0;   //可能的最小左括号数
        int hi = 0;    //可能的最大的左括号数
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            if(cur == '(') {
                lo ++;
                hi ++;
            //如果碰到的是")"
            }else if(cur == ')') {
                if(lo > 0)
                    lo --;
                hi --;
            //如果是*，即可能是左也可能是右区间同时左右扩大
            }else {
                if(lo > 0)
                    lo --;
                 hi ++;
            }
            if(hi < 0)
                return false;
        }
        return lo == 0;
    }
}
