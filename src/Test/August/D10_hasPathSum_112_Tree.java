package Test.August;

/**
 * leetCode 112:路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22
 *
 */
public class D10_hasPathSum_112_Tree {
    static int temp = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(1);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;
        boolean b = hasPathSum(root, 22);
        System.out.println(b);
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        /*if(root == null)
            return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return (sum == 0);
        }
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);*/

        if(root == null)
            return false;
        temp += root.val;
        if(root.left == null && root.right == null)
            if(temp == sum){
                return true;
            }else{
                temp -= root.val;
                return false;
            }

        else
            return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}
