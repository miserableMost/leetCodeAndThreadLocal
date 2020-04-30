package medium;

/**leetCode 142 : 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 */
public class T142_detectCycle_9_11 {
    public static void main(String[] args) {

    }
    //构建双指针第一次相遇：
    //
    //    设两指针 fast，slow 指向链表头部 head，fast 每轮走 222 步，slow 每轮走 111 步；
    //    若 fast 指针走过链表末端，说明链表无环，直接返回 null（因为每走 111 轮，fast 与 slow 的间距 +1+1+1，若有环，快慢两指针终会相遇）；
    //    当 fast == slow 时，代表两指针在环中 第一次相遇，此时执行 breakbreakbreak 跳出迭代；
    //    第一次相遇时步数分析： 设链表头部到环需要走 aaa 步，链表环走一圈需要 bbb 步，则链表共有 a+ba+ba+b 个节点；设两指针分别走了 fff， sss 步，则有：
    //        快指针走了慢指针 222 倍的路程，即 f=2sf = 2sf=2s；（fast 每轮走 222 步，slow 每轮走 111 步）
    //        快指针比慢指针多走了 nnn 个环的长度，即 f=s+nbf = s + nbf=s+nb；（双指针都走过 aaa 步，直到相遇 fast 比 slow 多走整数倍环的长度）
    //        代入可推出：f=2nbf = 2nbf=2nb，s=nbs = nbs=nb，即快慢指针分别走了 2n2n2n，nnn 个环的周长。
    //
    //构建双指针第二次相遇：
    //
    //    将 fast 指针重新指向链表头部 head，slow 指针位置不变，此时 fast走了 000 步，slow 指针走了 nbnbnb 步；
    //    令双指针一起向前走，两指针每轮都走 111 步；
    //    当 fast 指针走到 aaa 步时，slow 指针正好走到 a+nba + nba+nb 步，此时 两指针重合并同时指向链表环入口 。
    //    最终返回 fast 或 slow 即可。
    //
    //复杂度分析：
    //
    //    时间复杂度 O(N)O(N)O(N) ：第二次相遇中，慢指针须走步数 a<a+ba < a + ba<a+b；第一次相遇中，慢指针须走步数 a+b−x<a+ba + b - x < a + ba+b−x<a+b，其中 xxx 为双指针重合点与环入口距离；因此总体为线性复杂度；
    //    空间复杂度 O(1)O(1)O(1) ：双指针使用常数大小的额外空间。
    //
    public ListNode detectCycle(ListNode head) {
        /*Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if(visited.contains(cur)) {
                return cur;
            }
            visited.add(cur);
            cur = cur.next;
        }
        return null;*/
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            //无环时
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                break;
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
