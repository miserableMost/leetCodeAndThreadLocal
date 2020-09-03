package testAgin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/7/6 23:27
 */
class LRUCache {

    class DLinkedNode {
        int key, value;
        DLinkedNode pre, next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public void addNode(DLinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    public void removeNode(DLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    DLinkedNode head,tail;


    public LRUCache(int capacity) {
        int size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null) {
            node = new DLinkedNode(key,value);
            map.put(key,node);
            addNode(node);
            size ++;
            if(size > capacity) {
                DLinkedNode tail = popTail();
                map.remove(tail.value);
                size --;
            }
        }else {
            node.value = value;
            map.put(key,node);
        }
    }
}