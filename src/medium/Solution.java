package medium;

/**
 * leetCode 382 链表随机节点
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 */
//蓄水池抽样法
//思路：从左向右遍历链表，每遇到一个节点，计数器cnt加1。然后生成随机数j在范围[0,…,cnt-1]中。
// 如果j < 1 那么，取此位置。如果不是，则不取。
//使用1/i 这个概率值选取第 i 个节点了。
public class Solution {
    private ListNode head;    //定义一个头节点
    private int len;          //定义链表的长度
    public Solution(ListNode head) {
        this.head = head;
        ListNode tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            len ++;
        }

    }

    /** Returns a random node's value. */
    public int getRandom() {

       //产生一个随机数--生成第几个数就取第几个节点
        int num = (int) (Math.random() * len + 1);
        ListNode cur = head;
        for (int i = 1; i < num; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}
