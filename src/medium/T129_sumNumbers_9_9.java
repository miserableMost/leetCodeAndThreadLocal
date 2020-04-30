package medium;

/**
 * leetCode 129 : 求根到叶子结点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 */
public class T129_sumNumbers_9_9 {
    private int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        T129_sumNumbers_9_9 test = new T129_sumNumbers_9_9();
        int i = test.sumNumbers(root);
        System.out.println(i);
    }
    public int sumNumbers(TreeNode root) {
        add(root,0);
      //  System.out.println(sum);
        return sum;
    }

    public void add(TreeNode root,int cur) {
        if(root == null)
            return;
        cur += root.val;
        //到达根节点
        if(root.left == null && root.right == null) {
            sum += cur;
            //cur = 0;
            return;
        //未到根节点
        }else {
            add(root.left,cur * 10);
            add(root.right,cur * 10);
        }

    }
}
