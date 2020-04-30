package medium;

/**
 * leetCode 148 : 排序列表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class T148_sortList_8_24 {
    public static void main(String[] args) {

    }
    //当使用fast = head.next时，前面的链表长度始终大于等于后面的链表
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head.next == null)
            return head;
        //当使用fast = head.next时，包含slow的前面的链表长度始终大于等于后面的链表,slow停在中间(奇数)或前面（偶数)
        //当使用fast = head时，slow停在中间（奇数)或后面(偶数)
        ListNode slow = head,fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(fast);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
       ListNode pre = new ListNode(0);
       ListNode cur = pre;
       while(left != null && right != null){
           if(left.val < right.val){
               cur.next = left;
               left = left.next;
           }else {
               cur.next = right;
               right = right.next;
           }
           cur = cur.next;
       }
       cur.next = left == null ? right : left;
       return pre.next;

    }

}
