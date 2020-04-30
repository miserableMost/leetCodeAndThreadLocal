package tryTest;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (isLeftLeave(root.left)) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    private boolean isLeftLeave(TreeNode treeNode) {
        return treeNode != null && (treeNode.left == null && treeNode.right == null);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        Solution s = new Solution();
        int i = s.sumOfLeftLeaves(t1);
        System.out.println(i);

    }
}
