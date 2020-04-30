package hard.ByteDance;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/3/30 15:58
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class T445_两数相加2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        ListNode node = addTwoNumbers(l1, r1);
        System.out.println("a");

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        ListNode dump = new ListNode(-1);

        int up = 0;  //进位
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int a = (s1.isEmpty()) ? 0 : s1.pop();
            int b = (s2.isEmpty()) ? 0 : s2.pop();
            int cur = (a + b + up) % 10;  //当前位置
            ListNode curNode = new ListNode(cur);
            curNode.next = dump.next;
            dump.next = curNode;

            up = (a + b + up) / 10;   //进位

        }
        //如果最后还有进位
        if(up != 0) {
            ListNode curNode = new ListNode(up);
            curNode.next = dump.next;
            dump.next = curNode;
        }
        return dump.next;

    }
}
