package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 19:19
 */
public class T11 {
    public void O1DeleteNode(ListNode head, ListNode needDelete) {
        if(needDelete.next != null) {
            //待删除节点非尾节点，将后一个节点的值复制到当前节点，然后删除后一个节点
            needDelete.val = needDelete.next.val;
            needDelete.next = needDelete.next.next;
        }else {
            //待删除的是尾节点,找到尾节点的前一个节点
            ListNode tmp = head;
            while(tmp != null) {
                if(tmp.next == needDelete)
                    break;
                tmp = tmp.next;
            }
            tmp.next = needDelete.next;

        }
    }
}
