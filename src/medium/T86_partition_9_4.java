package medium;

/**
 * leetCode 86 : 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class T86_partition_9_4 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
      /*  ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);*/
        l1.next = l2;
        l2.next = l3;
       /* l3.next = l4;
        l4.next = l5;
        l5.next = l6;*/
        ListNode partition = partition(l1, 3);
        System.out.println(partition);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode temp = dump;
        ListNode first = new ListNode(-1);
        boolean flag = false;    // //标记是否已经遇到第一个大于x的节点
        while(temp != null && temp.next != null){
            if(temp.next.val >= x && flag == false){
                flag = true;   //开启后面的操作
                first = temp;   //记录下第一个大于等于x的前一个节点
                temp = temp.next;
            //此时需要执行删除操作，不能将temp后移
            }else if(flag == true && temp.next.val < x) {
                ListNode tnode = temp.next;   ////记录下要移动到前面的节点
                temp.next = temp.next.next;  //删除
                //添加到前面去
                tnode.next = first.next;
                first.next = tnode;
                //保持相对位置不变
                first = first.next;
            }else {
                temp = temp.next;
            }



         }
        return dump.next;
    }
}
