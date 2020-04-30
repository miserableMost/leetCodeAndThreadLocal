package PSoffer;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2019/12/19 15:32
 * 两个栈实现一个队列
 */
public class T5 {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    public static void main(String[] args) {

    }
    public void push(int node) {
        pushStack.push(node);
    }
    public int pop() {
        //一定要保证pop栈为空，才从push栈中倒入数据
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty())
            return -1;
        else
            return popStack.pop();

    }

}
