package Test.July;

/**
 * leetCode 538 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class Test538_convertBST_7_23 {
    int sum = 0;
    public static void main(String[] args) {

    }
    public TreeNode convertBST(TreeNode root) {
         doConvertBST(root);
         return root;


    }
    public void doConvertBST(TreeNode root){
        if(root == null) {
            return;
        }
        doConvertBST(root.right);
        root.val += sum;
        sum = root.val;
        doConvertBST(root.left);





    }

}
