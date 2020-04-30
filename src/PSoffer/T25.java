package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/22 17:56
 */
public class T25 {
    TreeNode pre = null;
    TreeNode lastLeft = null;
    public static void main(String[] args) {

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null)
            pre.right = pRootOfTree;
        pre = pRootOfTree;
        lastLeft = lastLeft == null ? pRootOfTree : lastLeft;
        Convert(pRootOfTree.right);
        return lastLeft;
    }
}
