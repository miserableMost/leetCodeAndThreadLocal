package Test.July;

/**
 * leetCode 226:翻转二叉树
 * 翻转一棵二叉树。
 */
public class Test226_invertTree_31 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //右子树翻一下
        TreeNode right = invertTree(root.right);
        //左子树翻一下
        TreeNode left = invertTree(root.left);
        //交换一下
        root.left = right;
        root.right = left;
        return root;


        /* reverse(root);
         return root;*/
    }
    public void reverse(TreeNode root){
        if(root == null)
            return;
        //进行左右交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
}
