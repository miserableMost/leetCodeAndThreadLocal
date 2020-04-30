package Test.October;



public class T328_oddEvenList_10_20 {
    public static void main(String[] args) {

    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        //定义偶数列表的头和指针
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        //保证偶数
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            //此时奇数节点跑到下一个偶数前面
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
