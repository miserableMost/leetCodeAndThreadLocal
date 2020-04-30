package Test.July;

/**
 * leetCode 543:二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class Test543_diameterOfBinaryTree_7_24 {
    //套路：求最大值就得定义一个最小的，不断与之比较
     int max = 0;
    public static void main(String[] args) {

    }
    public int diameterOfBinaryTree(TreeNode root) {
         if(root == null)
             return 0;
         getHeight(root);
         return max;


    }

    //应遍历求出每个节点的最大路径：并不一定是根节点最大
    //此方法求出每个节点的高度
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        //求出左子树的高低
        int left = getHeight(node.left);
        //求出右子树
        int right = getHeight(node.right);
        //对于每一个节点来说，左子树的高度加上右子树的高度就是最大路径
        if(left + right > max)
            max = left + right;
        return Math.max(left,right) + 1;

    }
}
