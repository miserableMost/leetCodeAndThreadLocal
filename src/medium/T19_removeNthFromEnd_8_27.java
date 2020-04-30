package medium;

/**
 * leetCode 19 : 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class T19_removeNthFromEnd_8_27 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode l1 = dump;
        ListNode l2 = dump;
        for (int i = 1; i <= n + 1; i++) {
            l1 = l1.next;  //l1移动到第n+1个位置
        }
        while(l1 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return dump.next;

    }
}
