package Test.August;

/**
 * leetCode 530 :二叉搜索树的最小绝对值差
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 */
public class D4_getMinimumDifference_530_Tree {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }
    //BST中序遍历是升序，所以遍历时求相邻两个节点之间的最小绝对差值即可
    public int getMinimumDifference(TreeNode root) {
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
            //求相邻节点的差值
            min = Math.min(min,Math.abs(root.val - pre.val));
        pre = root;
        minDif(root.right);
    }
}
