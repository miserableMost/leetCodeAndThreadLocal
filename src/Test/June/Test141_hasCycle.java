package Test.June;

/**
 * leetCode : 141 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示
 * 链表尾连接到链表中的位置（索引从 0 开始）
 * 如果 pos 是 -1，则在该链表中没有环。
 *

 */
public class Test141_hasCycle {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node2));

    }


    public static boolean hasCycle(ListNode head) {
        //快慢指针
        //若走的快的指针能跟慢的相遇，则必然有环
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //以走的快的指针为判断，需同时判断fast.next，否则空指针异常
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;

    }
}
