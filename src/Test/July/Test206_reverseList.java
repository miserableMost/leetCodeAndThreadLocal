package Test.July;

/**
 * leetCode 206 :反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Test206_reverseList {

    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
       //创建一个临时节点
        ListNode tmp = head;
        ListNode next = null;
        //创建一个新链表
        ListNode resultHead = new ListNode(0);
        //还没到最后一个
       while(tmp != null){
           //记住一定要保存原链表的下一个节点，以免丢失
           next = tmp.next;
           //添加进来
           tmp.next = resultHead.next;
           resultHead.next = tmp;
           tmp = next;
       }
       head = resultHead.next;
       return head;
    }
}

