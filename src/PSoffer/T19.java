package PSoffer;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2019/12/22 14:15
 * 最小栈
 */
public class T19 {
    public static void main(String[] args) {

    }
    private Stack<Integer> data;
    private Stack<Integer> helper;
    public T19() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    public void push(int x) {
        data.push(x);
        //当辅助栈为空或者栈顶元素大于或等于新来的元素
        if(helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
    }

    public void pop() {
        if(!data.isEmpty()) {
            int top = data.pop();
            if(top == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if(!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    public int getMin() {
        if(!helper.isEmpty()) {
            return helper.pop();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
