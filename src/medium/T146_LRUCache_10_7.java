package medium;

import java.util.Hashtable;

public class T146_LRUCache_10_7 {
    public static void main(String[] args) {

    }
    //定义一个双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int val) {
            this.key = key;
            this.value = val;
        }
    }

    //往头加
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }
    private void moveTohead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    //弹出尾部
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer,DLinkedNode> cache = new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;




    public T146_LRUCache_10_7(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        moveTohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //如果node为空
        if(node == null) {
            DLinkedNode curNode = new DLinkedNode(key,value);
            cache.put(key,curNode);
            addNode(curNode);
            size ++;
            //如果满了
            if(size > capacity) {
                //弹出队列末位的节点
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size --;
            }
        }else {
            //已有值，则更新
            node.value = value;
            //跑回队首
            moveTohead(node);
        }
    }
}
