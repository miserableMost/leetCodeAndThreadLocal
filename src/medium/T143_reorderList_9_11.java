package medium;

/**
 * leetCode  143 : 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class T143_reorderList_9_11 {
    public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        //找到中间节点
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //分成两个链表
        p2 = p1.next;
        p1.next = null;
        //将后边链表反转
        ListNode dump = new ListNode(-1);
        //dump.next = p2;
        ListNode temp = p2;
        ListNode next2 = p2;
        while(temp != null) {
            next2 = temp.next;
            temp.next = dump.next;
            dump.next = temp;
            temp = next2;
        }
        p2 = dump.next;
        //将两个链表合并
        p1 = head;
        ListNode next1 = p1;
        //之所以是p2为空，是由于奇数节点链表前面的节点数会比后面的多一个
        //也就是p2先为空
        while(p2 != null) {
            next1 = p1.next;
            next2 = p2.next;

            p1.next = p2;
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }

    }
}
