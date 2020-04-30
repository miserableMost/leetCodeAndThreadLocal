package Test.June;

/**
 * Test160 :相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Test160_getIntersectionNode {
    /**
     定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     **/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //设定两个指针

        if(headA == null || headB == null)
            return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        /**
         * 链表A ： a个相交前元素 + 交点 + x个相交后元素
         * 链表B ： b个相交前元素 + 交点 + x个相交后元素
         * 各自都走 （a + b + 交点 + x个相交后元素）,下一步能相交则必相交
         */

        while(pA.val != pB.val){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
