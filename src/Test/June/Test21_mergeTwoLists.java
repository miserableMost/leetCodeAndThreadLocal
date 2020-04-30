package Test.June;
/**
 * leetCode 21. 合并两个有序链表
 */

public class Test21_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
       ListNode head = null;
       if(l1.val < l2.val){
           head = new ListNode(l1.val);
           head.next = mergeTwoLists(l1.next,l2);
       }else{
           head = new ListNode(l2.val);
           head.next = mergeTwoLists(l1,l2.next);
       }
       return head;


    }
}
