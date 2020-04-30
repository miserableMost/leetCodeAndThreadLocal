package hard;

/**
 * @author 李聪
 * @date 2020/2/13 14:19
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 *     数字 0-9
 *     指数 - "e"
 *     正/负号 - "+"/"-"
 *     小数点 - "."
 *
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 */
public class T65_isNumber {
    public static void main(String[] args) {

    }
    public boolean isNumber(String s) {
        //去除空格
        s = s.trim();
        //记录点是否已经出现过
        boolean pointSeen = false;
        //记录e是否已经出现过
        boolean eSeen = false;
        //记录数字是否已经出现过
        boolean numberSeen = false;
        //记录e之后是否出现过数字
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {  //出现过e或者.之后，就不能再次出现.了
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {  //出现e的时候，前面必须没有出现过e,且前面一定要出现过数字,比如，1.e5可以而.e5就不可以
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {//当出现正负号的时候，它要么是首位，要么是紧跟在e之后的
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
