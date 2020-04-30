package medium;

/**
 * leetCode 114 :  二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 */
public class T114_flatten_9_8 {
    TreeNode dump = new TreeNode(-1);
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        while(root != null) {
            //左子树为空，直接考虑下一个节点
            if(root.left == null) {
                root = root.right;
            }else {
                //找到左子树的最右边节点--即左边的最大值
                TreeNode pre = root.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右节点
                pre.right = root.right;
                //将原左子树接到根的右边
                root.right = root.left;
                //根左边置空
                root.left = null;
                //考虑下一个节点
                root = root.right;
            }

        }
    }
}
