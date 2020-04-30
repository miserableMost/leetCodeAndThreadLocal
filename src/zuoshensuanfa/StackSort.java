package zuoshensuanfa;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/3/12 17:22
 */
public class StackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        sort(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    //用一个栈实现另一个栈的排序
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            //先将stack元素弹出来
            int cur = stack.pop();
            //如果cur大于help的栈顶元素，则将help一一弹出，确保大的在下面
            while(!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
