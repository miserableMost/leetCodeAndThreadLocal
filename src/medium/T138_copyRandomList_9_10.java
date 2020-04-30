package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 138 :
 */
public class T138_copyRandomList_9_10 {
    Map<Node,Node> map = new HashMap<>();
    public static void main(String[] args) {

    }
    /*public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        //复制每一个节点紧随其后
        while(cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //处理random节点--新节点的random指向原节点的random的下一个节点--注意random可能为空
        cur = head;
        while(cur != null) {
            cur.next.random = (cur.random != null)? cur.random.next : null;
            cur = cur.next.next;
        }
        //处理next节点--新节点的next节点指向它的下下个节点
        //之所以遍历老的链表，是使其还原成修改前的
        Node old_list = head;
        Node new_list = head.next;
        Node ans = head.next;
        while(old_list != null) {
            old_list.next = old_list.next.next;
            new_list.next = (new_list.next != null) ? new_list.next.next : null;
            new_list = new_list.next;
            old_list = old_list.next;
        }
        return ans;
    }*/
}
