package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/27 19:06
 */
public class T38 {
    public static void main(String[] args) {

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
}
