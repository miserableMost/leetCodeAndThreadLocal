package hard;

import newTest.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 */
public class T99_recoverTree_9_14 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(2);
        root.left = l1;
        root.right = l2;
        l1.right = l3;
        recoverTree(root);
    }

    /**
     * 这道题难点,是找到那两个交换节点,把它交换过来就行了.
     *
     * 这里我们二叉树搜索树的中序遍历(中序遍历遍历元素是递增的)
     *
     * 如下图所示, 中序遍历顺序是 4,2,3,1,我们只要找到节点4和节点1交换顺序即可!
     *
     * 这里我们有个规律发现这两个节点:
     *
     * 第一个节点,是第一个按照中序遍历时候前一个节点大于后一个节点,我们选取前一个节点,这里指节点4;
     *
     * 第二个节点,是在第一个节点找到之后, 后面出现前一个节点大于后一个节点,我们选择后一个节点,这里指节点
     *
     * @param root
     */
    //中序遍历，记录节点进行交换
    public static void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                if(firstNode == null && root.val < pre.val) {
                    //进行交换
                    firstNode = pre;
                }
                //第二个节点在更新中
                if(firstNode != null && root.val < pre.val) {
                    secondNode = root;
                }
                pre = root;
                root = root.right;
            }
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
