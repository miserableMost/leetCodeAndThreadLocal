package hard.ByteDance;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/4/9 21:29
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 *     () 得 1 分。
 *     AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 *     (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 *

 */
public class T856_括号的分数 {
    public static void main(String[] args) {

    }
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push(0);
            }else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v,1));
            }
        }
        return stack.pop();
    }
}
