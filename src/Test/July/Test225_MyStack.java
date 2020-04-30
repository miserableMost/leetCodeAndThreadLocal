package Test.July;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetCode 225:用队列实现
 */
public class Test225_MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    /** Initialize your data structure here. */
    public Test225_MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
         q1.add(x);
         top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
