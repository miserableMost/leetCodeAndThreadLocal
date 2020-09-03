package medium2.T284;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李聪
 * @date 2020/8/26 8:42
 */
public class llStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }

}
class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()){
            q1.add(x);
            for(int i = 0;i < q2.size();i ++){
                q1.add(q2.poll());
            }
        }else {
            q2.add(x);
            for(int i = 0;i < q1.size();i ++){
                q2.add(q1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.isEmpty() ? q2.poll() : q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
