package Test.July;

import java.util.Stack;

/**
 * leetCode 20:有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *

 */
public class Test20_isValid {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        boolean flag = false;
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //当栈不为空(一定要先判断栈是否为空)，并且遇到右括号时，立即检查栈顶元素是否为对应的左括号
            if (!stack.isEmpty() && ((c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='[') || (c=='}' && stack.peek()=='{'))){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        //当栈顶元素为空时，表示正确
        if(stack.isEmpty()){
            flag = true;
        }
        return flag;

    }
}
