package medium;

/**
 * @author 李聪
 * @date 2020/4/11 12:59
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 *
 * 例子:
 *
 * 输入: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * 输出: 返回二叉树的根 [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 */
public class T156_上下翻转二叉树 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        T156_上下翻转二叉树 t = new T156_上下翻转二叉树();
        t.upsideDownBinaryTree(t1);
        System.out.println("as");
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode LE = root.left, RI = root.right;
        TreeNode res = upsideDownBinaryTree(root.left);
        root.left = null;
        root.right = null;
        LE.right = root;
        LE.left = RI;
        return res;

    }
}
