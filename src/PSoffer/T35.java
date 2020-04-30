package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/26 10:14
 */
public class T35 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l1.next = l2;
        l2.next = l7;
        l7.next = l8;
        l8.next = l9;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        T35 t35 = new T35();
        ListNode ans = t35.FindFirstCommonNode(l1, l3);
        System.out.println(ans.val);

    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //定义两个指针
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while(l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;

    }
}
