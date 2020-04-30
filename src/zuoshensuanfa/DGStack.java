package zuoshensuanfa;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/3/12 16:17
 */
public class DGStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        //如果是最后一个元素就返回
        if(stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack) {
        //栈已空，返回
        if(stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
