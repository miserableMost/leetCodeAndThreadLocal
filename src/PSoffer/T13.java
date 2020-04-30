package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 20:06
 */
public class T13 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (fast != null) {
            fast = fast.next;
            if(i >= k) {
                slow = slow.next;
            }
            i ++;
        }
        if(i < k) {
            return null;
        }
        return slow;
    }
}
