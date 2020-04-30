package Test.August;

/**
 * leetCode 1022 : 从根到叶的二进制之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 */
public class D15_sumRootToLeaf_1022_Tree {
    int sum = 0;
    public static void main(String[] args) {

    }
    public int sumRootToLeaf(TreeNode root) {
         dfs(root,0);
         return (int) (sum % (Math.pow(10,9) + 7));
    }
    //从根节点开始遍历，每向下一个节点，
    public void dfs(TreeNode root,int val){
        if(root == null)
            return;
        // 我们可以把父节点传入的值左移一位并或上当前节点的值
        int newVal = (val << 1) | root.val;
        //只是判断一个节点是不是叶子节点，如果是的话就累加，否则继续。思路还是很清晰的。
        if(root.left == null && root.right == null){
            sum += newVal;
        }else{
            dfs(root.left,newVal);
            dfs(root.right,newVal);
        }
    }
}
