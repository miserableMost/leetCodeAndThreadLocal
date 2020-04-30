package Test.July;

/**
 * leetCode 563:二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1

 */
public class Test563_findTilt {
    int sum = 0;
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Test563_findTilt test = new Test563_findTilt();
        int i = test.findTilt(t1);
        System.out.println(i);
    }
    public  int findTilt(TreeNode root) {
         findSum(root);
         return sum;


    }
    public int findSum(TreeNode root){
        if(root == null)
            return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }


}
