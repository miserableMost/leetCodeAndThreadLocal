package medium;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *

 */
public class T2_addTwoNumbers_10_14 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = addTwoNumbers(l1, l4);
        System.out.println(listNode);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        //判断进位
        int up = 0;
        ListNode dump = new ListNode(0);
        ListNode pre = dump;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + up;
            int cur = sum % 10;

            ListNode curNode = new ListNode(cur);
            pre.next = curNode;
            pre = curNode;
            up = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }
        if(up != 0){
            ListNode curNode = new ListNode(up);
            pre.next = curNode;
        }
        return dump.next;

    }

}
