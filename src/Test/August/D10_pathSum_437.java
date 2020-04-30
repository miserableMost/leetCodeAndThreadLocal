package Test.August;

/**
 * leetCode 437:路径总和
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
 */
public class D10_pathSum_437 {
    public static void main(String[] args) {

    }
    //路径的开头可以不是根节点，结束也可以不是叶子节点，是不是有点复杂？
    //如果问题是这样：找出以根节点为开始，任意节点可作为结束，且路径上的节点和为 sum 的路径的个数；
    //是不是前序遍历一遍二叉树就可以得到所有这样的路径？是的；
    //如果这个问题解决了，那么原问题可以分解成多个这个问题；
    //是不是和数线段是同一个问题，只不过线段变成了二叉树；
    //在解决了以根节点开始的所有路径后，就要找以根节点的左孩子和右孩子开始的所有路径，三个节点构成了一个递归结构；
    //递归真的好简单又好难；
    public int pathSum(TreeNode root, int sum) {
       //先找根节点的，再找左节点，右节点
        if(root == null)
            return 0;
        return paths(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int paths(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int res = 0;
        if(root.val == sum)
            res += 1;
        res += paths(root.left,sum - root.val);
        res += paths(root.right,sum - root.val);
        return res;
    }
}
