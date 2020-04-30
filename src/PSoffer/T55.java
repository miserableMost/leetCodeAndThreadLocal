package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 11:07
 */
public class T55 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode dumy = new ListNode(-1);
        dumy.next = pHead;
        ListNode pre = dumy;
        ListNode last = dumy.next;
        while(last != null) {
            if(last.next != null && last.val == last.next.val) {
                while(last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else {
                pre = pre.next;
                last = last.next;
            }

        }
        return dumy.next;
    }
}
