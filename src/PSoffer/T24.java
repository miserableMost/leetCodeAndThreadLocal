package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/22 16:08
 * 复杂链表的拷贝
 */
public class T24 {
    public static void main(String[] args) {

    }
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null)
            return null;
        RandomListNode cur = pHead;
        while(cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            //将克隆的节点插入
            RandomListNode next = cur.next;
            cur.next = clone;
            clone.next = next;
            cur = next;
        }
        //将随机指针分配给克隆节点
        cur = pHead;
        //已经复制过了，不用担心为空
        while(cur != null) {
            //注意是radom.next，已经克隆了
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        //拆分链表
        cur = pHead;
        RandomListNode pClone = pHead.next;
        while(cur != null) {
            RandomListNode cloneNode = cur.next;
            cur.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            cur = cur.next;
        }
        return pClone;
    }
}



