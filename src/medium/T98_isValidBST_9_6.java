package medium;

import java.util.Stack;

/**
 * leetCode 98 : 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */
public class T98_isValidBST_9_6 {
    public static void main(String[] args) {

    }
    //非递归中序遍历二叉树，顺序排列就是二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        int pre = Integer.MIN_VALUE;
        boolean init = false; //为了忽略第一次的节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()) {
                cur = stack.pop();
                if(init && cur.val <= pre) //保证第一次不进判断
                    return false;
                init = true;
                pre = cur.val;
                cur = cur.right;

            }
        }
        return true;
    }
}
