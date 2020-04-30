package hard;

/**
 *  leetCode k个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 *     你的算法只能使用常数的额外空间。
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class T25_reverseKGroup_10_5 {
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
        T25_reverseKGroup_10_5 test = new T25_reverseKGroup_10_5();
        ListNode reverse = test.reverse(l1);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;     //pre为这一组的头节点的前一个节点
        ListNode end = dump;    //end 为这一组的最后一个节点，也是下一组的前一个节点
        while(end.next != null) {       //写end和end.next均可，因为循环中已经处理了end为空的情况
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null) {
                break;
            }
            //先保存下一组的头节点
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;  //这一组的头节点
            pre.next = reverse(start);   //反转
            //原本的头节点跑到最后去了，将原本断开的链表重新连接起来
            start.next = next;
            //重新操作
            pre = start;
            end = pre;
        }
        return dump.next;
    }
    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode dump = new ListNode(0);
       // ListNode pre = dump;
        ListNode temp = head;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = dump.next;
            dump.next = temp;
            temp = next;
        }
        return dump.next;
    }
}
