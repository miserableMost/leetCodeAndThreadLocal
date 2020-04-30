package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 12:43
 */
public class T57 {
    public static void main(String[] args) {

    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isMirror(pRoot,pRoot);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null || r2 == null)
            return false;

        return (r1.val == r2.val) && isMirror(r1.left,r2.right) && isMirror(r1.right,r2.left);
    }
}
