package Test.August;

public class D15_sumOfLeftLeaves_404_Tree {
    TreeNode pre = null;

    public static void main(String[] args) {

    }
    public int sumOfLeftLeaves(TreeNode root) {
        int count = 0;
        if(root == null)
            return 0;
        //判断是否是左叶子节点
        if(root.left == null && root.right == null){
            if(pre != null && pre.left == root){
                count = root.val;
            }
        }
        pre = root;
        //当前的+左子树+右子树
        return count + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);


    }
}
