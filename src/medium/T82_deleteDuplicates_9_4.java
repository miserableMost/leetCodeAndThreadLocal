package medium;

/**
 * leetCode 82: 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class T82_deleteDuplicates_9_4 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l6.next = l6;
        l6.next = l7;
        ListNode listNode = deleteDuplicates(l6);
        System.out.println(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
     /*   if(head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode temp = dump;  //用于指定可能重复元素的前一个元素
        while(temp.next != null) {
            //判断是否重复
            int val = temp.next.val;
            if(temp.next.next != null && temp.next.next.val == val) {
                //重复则将其全部找出来
                ListNode delete = temp.next.next;
                while(delete != null && delete.val == val) {
                    delete = delete.next;
                }
                temp.next = delete;
            }else {
                temp = temp.next;
            }
        }
        return dump.next;*/
        if(head == null || head.next == null)
            return head;
        //创建一个dump节点
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;     //用于标记是否重复
        while(fast != null){
            if(fast.val == slow.val){
                flag = true;

            }else {
                //重复--删除，并重置flag
                if(flag){
                    pre.next = fast;
                    slow = fast;
                    flag = false;
                //向后移
                }else {
                    pre = pre.next;
                    slow = slow.next;
                }

            }
            fast = fast.next;

        }
        //如果最后几个连续重复
        if(flag)
            pre.next = null;
        return dump.next;
    }
}
