package Test.June;

/**
 * T1 707 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，
 * 则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 *
 */


public class Test707_MyLinkedList {

    static MyListNode  head;
    static int length;
    /** Initialize your data structure here. */
    public Test707_MyLinkedList() {
        head = new MyListNode(-1);
        length = 0;

    }

    public static int getLength(){
        if(head.next == null){
            return 0;
        }
        MyListNode temp = head.next;
        while(temp != null){
            length ++ ;
            temp = temp.next;
        }
        return length;
    }

    /** 获取链表中第 index 个节点的值。如果索引无效，则返回-1。 */
    public int get(int index) {

        int length = getLength();
        if(index < 0 || index >= length){
            return -1;
        }
        MyListNode temp = head.next;
        int count = 0;
        while(true){
            if(count == index){
                return temp.val;
            }
            count ++;
            temp = temp.next;
        }

    }

    /** 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点 */
    public void addAtHead(int val) {
        MyListNode addNode = new MyListNode(val);
        addNode.next = head.next;
        head.next = addNode;
    }

    /** 将值为 val 的节点追加到链表的最后一个元素。 */
    public void addAtTail(int val) {
        MyListNode addNode = new MyListNode(val);
        MyListNode temp = head.next;
        while(true){
            //找到了最后一个
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //退出循环表示找到了最后一个节点
        temp.next = addNode;
    }

    /**在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     */
    public void addAtIndex(int index, int val) {

        int length = getLength();
        MyListNode addIndex = new MyListNode(val);
        if(index > length){
            return;
        }
        if(index < 0){
            addAtHead(val);
        }
        if(index == length){
            addAtTail(val);
        }
        MyListNode temp = head.next;
        int count = 0;
        while(true){
            if(count == index - 1){
                break;
            }
            count ++;
            temp = temp.next;
        }
        //跳出循环时为index的前一个节点
        addIndex.next = temp.next;
        temp.next = addIndex;
   }

    /** 如果索引 index 有效，则删除链表中的第 index 个节点 */
    public void deleteAtIndex(int index) {

        int length = getLength();
        if(index < 0 || index >= length){
            return;
        }
        MyListNode temp = head.next;
        int count = 0;
        while(true){
            if(count == index-1){
                break;
            }
            count ++;
            temp = temp.next;
        }
        //跳出循环时找到了第index个节点的前一个节点
        temp.next = temp.next.next;

    }

    //显示链表【遍历】
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我么需要一个辅助变量来遍历
        MyListNode temp = head.next;
        while(true){
            //判断列表是否到链表最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}

class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "MyListNode{" +
                "val=" + val +

                '}';
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

