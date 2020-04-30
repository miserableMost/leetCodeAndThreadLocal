package medium;

/**
 * leetCode 1038:从二叉搜索树到更大和树
 * 给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 *     节点的左子树仅包含键小于节点键的节点。
 *     节点的右子树仅包含键大于节点键的节点。
 *     左右子树也必须是二叉搜索树。
 *
 *
 */
public class T1038_bstToGst_10_27 {
    public static void main(String[] args) {

    }
    public TreeNode bstToGst(TreeNode root) {
        updateTree(root,0);
        return root;
    }
    //思路：根据二叉搜索树的定义，大于根结点的值都在右子树上，小于根结点的值都在左子树上，
    // 于是此题要求将二叉搜索树转变为更大和树，便可等价为求某个节点右边的节点和加上当前节点值(这个值就是题目所说的更大和）
    // 赋值给当前节点的新树，那么如何求这个更大和呢？
    // 根据二叉搜索树的性质，我们只需按照反转的中序遍历即可求到某个节点的更大值和。
    private int updateTree(TreeNode root, int parentSum) {
        if(root == null)
            return parentSum;
        //反中序遍历
        int right = updateTree(root.right,parentSum);
        root.val += right;
        return updateTree(root.left,root.val);
    }
}
