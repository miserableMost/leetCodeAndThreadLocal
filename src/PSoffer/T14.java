package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 20:37
 */
public class T14 {
    public static void main(String[] args) {

    }
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(0);
        ListNode tmp = head;
        while(tmp != null) {
            ListNode next =  tmp.next;
            tmp.next = dump.next;
            dump.next = tmp;
            tmp = next;
        }
        return dump.next;
    }
}

