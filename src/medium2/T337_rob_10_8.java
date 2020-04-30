package medium2;

/**
 * leetCode 337 打家劫舍|||
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class T337_rob_10_8 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        //左孩子能偷的最大金额
        int leftChildMoney = rob(root.left);
        //右孩子能偷的最大金额
        int rightChildMoney = rob(root.right);
        //左孩子的左孩子能偷的最大金额
        int leftChildLeft = 0;
        //左孩子的右孩子能偷的最大金额
        int leftChildRight = 0;
        //右孩子的左孩子能偷的最大金额
        int rightChildLeft = 0;
        //右孩子的右孩子能偷的最大金额
        int rightChildRight = 0;
        if(root.left != null) {
            leftChildLeft = rob(root.left.left);
            leftChildRight = rob(root.left.right);
        }
        if(root.right != null) {
            rightChildLeft = rob(root.right.left);
            rightChildRight = rob(root.right.right);
        }
        //比较左孩子和右孩子之和   与  根节点+左孩子的左孩子+左孩子的右孩子+右孩子的左孩子+右孩子的右孩子 的大小
        return Math.max(leftChildMoney + rightChildMoney,root.val + leftChildLeft + leftChildRight + rightChildLeft + rightChildRight);

    }
}
