package Test.August;

/**
 * leetCode 572 : 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
 *
 */
public class D15_isSubtree_572_Tree {
    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return t == null;
        return subFrom(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);


    }
    public boolean subFrom(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}
