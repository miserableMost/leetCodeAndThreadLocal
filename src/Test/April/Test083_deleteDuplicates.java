package Test.April;

import Test.April.utils.ListNode;

/**
 * leetCode 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 *  Definition for singly-linked list.
 *      * public class ListNode {
 *      *     int val;
 *      *     ListNode next;
 *      *     ListNode(int x) { val = x; }
 */
public class Test083_deleteDuplicates {
    /**
     * 因此，也就有了我们解递归题的三部曲：
     * 找整个递归的终止条件：递归应该在什么时候结束？
     * 找返回值：应该给上一级返回什么信息？
     * 本级递归应该做什么：在这一级递归中，应该完成什么任务？
     */
    //此链表已经排好序
    public static ListNode deleteDuplicates(ListNode head) {
          if(head == null)
              return head;
          while(head.next != null && head.val == head.next.val){
              head.next = head.next.next;
          }
          head.next = deleteDuplicates(head.next);
          return head;
    }

}

