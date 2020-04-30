package hard;

/**leetCode 23 合并两个有序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class T23_mergeKLists_9_28 {
    public static void main(String[] args) {

    }
    /*public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
           return null;
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)-> o1.val - o2.val);
        for (ListNode list : lists) {
            if(list == null)
                continue;
            queue.add(list);
        }
        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = cur.next;
            if(temp.next != null) {
                queue.add(temp.next);
            }
        }
        return dump.next;
    }*/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid,j = 0; i < lists.length; i++,j++) {
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = null;
        if(l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
    private ListNode mergekList(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while(len>1) {
            for (int i=0; i<len/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = (len + 1)/2;
        }
        return lists[0];
    }
}
