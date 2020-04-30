package medium;



public class T147_insertionSortList_8_24 {

    public static void main(String[] args) {

    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
         ListNode ans = new ListNode(-1);   //创建一个新的链表
         ListNode temp = head;
         ListNode cur = ans;
         while(temp != null){
             while(cur.next != null && cur.next.val < temp.val){
                 cur = cur.next;
             }
             //跳出循环找到了该插入的地方
             ListNode next = temp.next;
             ListNode ansNext = cur.next;
             //进行插入
             cur.next = temp;
             temp.next = ansNext;
             //后移
             temp = next;
             //将新链表指针重新置头
             cur = ans;
         }
         return ans.next;

    }

}
