package Test.June;

/**leetCode 203 :移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 */
public class Test203_removeElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = removeElements(node1, 1);
        show(node);
    }

    public static void show(ListNode head){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode temp = header;
        while(temp.next != null){

            if(temp.next.val == val){
                //执行删除,此时temp的下一个节点移动，相当于已经后移了
                temp.next = temp.next.next;
            }else{   //一定是else,若不是，当最后一个节点要求删除时，继续next会出现空指针异常
                temp = temp.next;
            }

        }

        return header.next;

    }

}
