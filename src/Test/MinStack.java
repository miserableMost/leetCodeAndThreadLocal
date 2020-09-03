package Test;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/5/2 15:34
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || data.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop() {
        int num = data.pop();
        if(helper.peek() == num) {
            helper.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
