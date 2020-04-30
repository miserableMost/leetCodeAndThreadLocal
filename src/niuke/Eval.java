package niuke;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2019/12/7 11:00
 */
public class Eval {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++) {
            if(tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            }else if(tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        if(!stack.isEmpty()) {
            return stack.pop();
        }
        return 0;
    }
}
