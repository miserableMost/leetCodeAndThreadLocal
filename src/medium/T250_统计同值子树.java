package medium;

/**
 * @author 李聪
 * @date 2020/4/11 17:39
 * 给定树中的一个结点，若其满足下面条件中的一个，则子树同值:
 *
 *     该节点没有子结点 （基本情况）
 *     该节点的所有子结点都为同值子树，且结点与其子结点值相同。
 *
 * 这样我们可以在树中使用深度优先搜索，自底向上的判断每个子树是否为同值子树。
 *
 */
public class T250_统计同值子树 {
    private int count = 0;
    public static void main(String[] args) {

    }

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        is_uni(root);
        return count;
    }

    private boolean is_uni(TreeNode root) {
        if(root.left == null && root.right == null) {
            count ++;
            return true;
        }
        boolean is_uni = true;
        if(root.left != null) {
            is_uni = is_uni(root.left) && is_uni && root.left.val == root.val;
        }
        if(root.right != null) {
            is_uni = is_uni(root.right) && is_uni && root.right.val == root.val;
        }
        //左右子树有一个不是
        if(!is_uni)
            return false;
        count ++;
        return true;
    }
}
