package medium2;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 */
public class T227_calculate_9_25 {
    public static void main(String[] args) {
        String s = "3+2*2";
        int c = calculate(s);
        System.out.println(c);
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //去掉所有的空格
        s = s.replaceAll(" ","");
        char c = '+';   //记录一个符号,,相当于在表达式最前面写了一个+
        int num = 0;    //计算
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
            if(ch < '0' || i == s.length() - 1) { //不加i == s.length() - 1则最后一个num没有操作
                //字符串仅包含非负整数，且此处是c不是ch--永远处理的是上一个符号
                switch (c) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                c = ch;
            }
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
