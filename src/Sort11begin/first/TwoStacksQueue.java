package Sort11begin.first;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 */
public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }
    //必须满足两点：
    //1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入
    //2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        }else if(stackPop.empty()) {
            while(!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        }else if(stackPop.empty()) {
            while(!stackPop.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
