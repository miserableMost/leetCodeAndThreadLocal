package Test.June;

public class Test876_middleNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        /*ListNode node4 = new ListNode(1);*/
        node1.next = node2;
        node2.next = node3;
       /* node3.next = node4;*/
        ListNode listNode = middleNode(node1);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        int length = getLength(head);
        ListNode p = head;
        ListNode result = new ListNode(0);

        for (int i = 0; i < length/2; i++) {
            p = p.next;
        }
        result = p;
        return result;
    }
    public static int getLength(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count ++ ;
            temp = temp.next;
        }
        return count;
    }


}
