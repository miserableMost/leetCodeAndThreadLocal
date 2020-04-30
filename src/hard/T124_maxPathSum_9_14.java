package hard;

import newTest.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 */
public class T124_maxPathSum_9_14 {
    private int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        //小于0不考虑
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        ////求的过程中考虑包含当前根节点的最大路径
        maxValue = Math.max(maxValue,root.val + left + right);
        //只返回包含当前根节点和左子树或者右子树的路径
        return root.val + Math.max(left,right);

    }
}
