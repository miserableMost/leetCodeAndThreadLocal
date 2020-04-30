package findJob;





/**
 * @author 李聪
 * @date 2020/2/21 20:24
 */

public class Test {
    public static void main(String[] args) {
       
            ListNode l1 = new ListNode(-9);
            ListNode l2 = new ListNode(3);
            ListNode l3 = new ListNode(5);
            ListNode l4 = new ListNode(7);

            l1.next = l2;
            l3.next = l4;
        Test test = new Test();
        test.mergeTwoLists(l1,l3);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode pre = dump;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        while(l1 != null) {
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }
        while(l2 != null) {
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }
        return dump.next;
    }
}

