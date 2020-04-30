package medium;

/**
 * leetCode 92 : 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class T92_reverseBetween_9_5 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        T92_reverseBetween_9_5 test = new T92_reverseBetween_9_5();
        test.reverseBetween(l1,2,4);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //定义要反转的头
        head = pre.next;
        for (int i = m; i < n; i++) {
            //不断拿出head后面的节点加到pre后面
            ListNode nex = head.next;
            head.next = nex.next;
            //不能写成head,第一波是head，后面就不是了
            nex.next = pre.next;
            pre.next = nex;
        }
        return dump.next;
    }
}
