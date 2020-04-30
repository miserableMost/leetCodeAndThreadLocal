package medium;

/**
 * leetCode 109 : 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class T109_sortedListToBST_9_7_REMEMBER {
    public static void main(String[] args) {

    }
    /*//左-根-右升序
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode middle = findMiddleNode(head);
        TreeNode root = new TreeNode(middle.val);
        if(middle == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }
    //将一个链表分成两个链表
    private ListNode findMiddleNode(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null) {
            pre.next = null;
        }
        return slow;
    }*/
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        return helper(head,null); //左闭右开
    }
    private TreeNode helper(ListNode head,ListNode tail) {
        if(head == tail)
            return null;
        ListNode slow = head,fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,tail);
        return root;
    }
}
