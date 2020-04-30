package Test.August;

/**
 * leetCode 783: 二叉搜索树节点的最小距离
 *给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 */
public class D4_minDiffInBST_783_Tree {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }
    //思路分析：首先我们应该知道二叉搜索树的定义，即左子树任意节点val < root->val < 右子树任意节点val，
    //同时左子树、右子树也满足这一定义（递归定义）。
    //这就造成了二叉搜索树的中序遍历为有序递增的序列，因此差值最小的距离必定出现在中序遍历的两个
    //相邻的节点。所以我们采取中序遍历遍历二叉树，我们可以先得到中序遍历序列再找最小距离，
    //也可以使用preVal记录当前正在访问的节点在中序遍历前的一个元素的值。
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        minDif(root);
        return min;
    }
    public void minDif(TreeNode root){
        if(root == null)
            return;
        minDif(root.left);
        if(pre != null)
            min = Math.min(min,root.val - pre.val);
        pre = root;
        minDif(root.right);
    }
}
