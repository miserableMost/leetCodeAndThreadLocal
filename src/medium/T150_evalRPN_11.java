package medium;

import java.util.Stack;

/**
 * leetCode 150 : 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 */
public class T150_evalRPN_11 {
    public static void main(String[] args) {
        String[] token = {"2", "1", "+", "3", "*"};

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            }else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")) {
                int num = stack.pop();
                stack.push(stack.pop() / num);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
