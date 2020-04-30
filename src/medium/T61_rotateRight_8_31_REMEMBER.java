package medium;

/**
 * leetCode 61:旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class T61_rotateRight_8_31_REMEMBER {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        rotateRight(head,2);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode old_tail = head;
        int n = 1;   //用于计算链表的个数
        while(old_tail.next != null){ //遍历到最后一个
            n ++;
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        ListNode new_tail = head;
        //如果要将链表每个结点向右移动 2 个位置，那倒数第 2 个结点就是旋转后新链表的起始位置；
        // 如果要将链表每个结点向右移动 3 个位置，那倒数第 3 个结点就是旋转后新链表的起始位置；
        // 而如果要将链表每个结点向右移动 33 个位置，那倒数第 3 个结点就是旋转后新链表的起始位置
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode newHead = new_tail.next;
        new_tail.next = null;
        return newHead;
    }






}
