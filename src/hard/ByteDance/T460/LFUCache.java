package hard.ByteDance.T460;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/3/28 20:00
 */
public class LFUCache {
    Map<Integer,Node> cache;
    Map<Integer,DoubleLinkedList> freqMap;  //存每个访问频次对应的Node的双向链表
    int size;
    int capacity;
    int min;   //存储最小频次
    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)
            return -1;
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                DoubleLinkedList minFreqLinkedList = freqMap.get(min);
                cache.remove(minFreqLinkedList.tail.pre.key);
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.pre); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoubleLinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new DoubleLinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addNode(newNode);
            size++;
            min = 1;
        }


    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        DoubleLinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        //如果拿掉后链表为空
        if (freq == min && linkedList.head.post == linkedList.tail) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoubleLinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);


    }

}
class Node {
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node post;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }

    void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }
    void addNode(Node node) {
        node.post = head.post;
        head.post.pre = node;
        node.pre = head;
        head.post = node;

    }
}