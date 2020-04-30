package Test.July;

/**
 * leetCode 110:平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Test110_isBalanced {
    boolean flag = true;
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
         height(root);
         return flag;

    }

    public  int height(TreeNode root){
        if(root == null)
            return 0;
        //获得左子树的高度
        int left = height(root.left) + 1;
        //获得右子树的高度
        int right = height(root.right) + 1;
        //如果左右子树高度差大于1则返回false
        if(Math.abs(left - right) > 1)
            flag = false;
        //返回当前节点的高度
        return Math.max(left,right);
    }

}
