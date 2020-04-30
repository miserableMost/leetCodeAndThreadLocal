package hard;

/**
 * leetCode 124 : 二叉树中的最大路径和
 *
 */
public class T124_maxPathSum_11_3 {
    private int res = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    private int maxGain(TreeNode root){
        if(root == null)
            return 0;
        int left = maxGain(root.left);
        int right = maxGain(root.right);
        //这条路径
        res = Math.max(left + right + root.val,res);
        //因为存在负数，0表示不要这条路
        return Math.max(Math.max(left,right) + root.val,0);
    }
}
