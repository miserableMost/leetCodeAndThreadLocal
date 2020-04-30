package Test.August;

/**
 * leetCode 1021:删除最外层的括号
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S
 */
public class D15_removeOuterParentheses_1021 {
    public static void main(String[] args) {
        String s = removeOuterParentheses("(()(()))");
        System.out.println(s);
    }
    public static String removeOuterParentheses(String S) {
        int left = 0;   //记录左括号
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            //第一个左括号不要--利用先运算在加
            if(c == '(' && left ++ > 0)
                sb.append('(');
            //--在前最后一个右括号也不要了--利用先减再运算
            if(c == ')' && --left > 0)
                sb.append(')');
        }
        return sb.toString();
    }
}
