package Test.June;



/**
 * Test237  删除链表中的节点
 * //正解：把后续节点拷贝过来
 * node.val = node.next.val
 * node.next = node.next.next
 *
 */
public class Test237_deleteNode {

    public static void main(String[] args) {
        deleteNode(new ListNode(1));

    }




    public static void deleteNode(ListNode node) {
        //创建一个链表
        SinglinkedList sing = new SinglinkedList();

       // ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        //sing.add(node1);
        sing.add(node2);
        sing.add(node3);
        sing.add(node4);

        boolean flag = false;
        ListNode head = sing.getHead();
        ListNode temp = head;
        while(true){
            if(temp.next == null){
                //已经到最后一个了
                break;
            }
            if(temp.next.val == node.val){
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("没有找到节点，删除失败");
        }
        sing.show();

    }
}

class SinglinkedList {
    private ListNode head = new ListNode(4);
    public ListNode getHead(){
        return head;
    }
    public void add(ListNode node){
        ListNode temp = head;
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show(){
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
}




