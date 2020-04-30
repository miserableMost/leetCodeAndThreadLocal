package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/27 19:03
 */
public class T37 {
    public static void main(String[] args) {

    }
    public int TreeDepth(TreeNode root) {
        return getDepth(root);
    }
    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
