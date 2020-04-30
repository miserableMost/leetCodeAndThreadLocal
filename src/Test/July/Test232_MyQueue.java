package Test.July;

import java.util.Stack;

/**
 * leetCode 232:用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 *     push(x) -- 将一个元素放入队列的尾部。
 *     pop() -- 从队列首部移除元素。
 *     peek() -- 返回队列首部的元素。
 *     empty() -- 返回队列是否为空。
 */
public class Test232_MyQueue {
    /** Initialize your data structure here. */
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public Test232_MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //入队：使用两个栈 先进先出,当前压入的元素进入栈底
        if(s1.empty())
            front = x;
        while(!s1.isEmpty())
            //将s1中元素全部压入s2中
            s2.push(s1.pop());
        //将当前元素压入s2中
        s2.push(x);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
   //出队
    public int pop() {
        int res = s1.pop();
        if(!s1.empty()) {
            //队列的头
           front = s1.peek();
        }
        return res;
    }

    /** Get the front element. */
    //取队首元素
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

