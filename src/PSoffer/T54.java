package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 21:29
 */
public class T54 {
    public static void main(String[] args) {

    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
         if(fast == null || fast.next == null)
             return null;
         slow = pHead;
         while(slow != fast){
             slow = slow.next;
             fast = fast.next;
         }
         return slow;
    }
}
