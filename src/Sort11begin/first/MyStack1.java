package Sort11begin.first;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class MyStack1 {
    //定义两个栈
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    private MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    //压入规则；当前数据为newNum。先将其压入stackData。然后判断stackMin是否为空：
    //1.如果为空，则newNum也压入stackMin
    //2.如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小
    //3.如果newNum更小或者两者相等，则newNum也压入stackMin；
    //4.如果stackMin中栈顶元素小，则stackMin不压入任何内容。
    private void push(int newNum) {
        if(stackMin.isEmpty()) {
            stackMin.push(newNum);
        }else if(newNum <= this.getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }
    //弹出规则与压入规则对应
    //当value等于stackMin的栈顶元素时，stackMin弹出栈顶元素；当value大于stackMin的栈顶元素时，stackMin不弹出栈顶元素；返回value;
    private int pop() {
        if(stackData.isEmpty()) {
            throw new RuntimeException("栈已为空");
        }
        int value = stackData.pop();
        if(value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }
    private int getMin() {
        if(stackMin.isEmpty()) {
            throw new RuntimeException("栈已为空");
        }
        return stackMin.peek();
    }
}
