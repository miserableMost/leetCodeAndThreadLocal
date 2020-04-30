package Test.August;

/**
 * leetCode 687:最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 */
public class D2_longestUnivaluePath_687_Tree {
    int maxPath = 0;
    public static void main(String[] args) {

    }
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
          getMaxPath(root,root.val);
          return maxPath;
    }
    /**
     解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
     1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
     2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
     需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
     **/
    public  int getMaxPath(TreeNode root,int val){
         if(root == null)
             return 0;
         int left = getMaxPath(root.left,root.val);
         int right = getMaxPath(root.right,root.val);
         maxPath = Math.max(maxPath,left + right);  // 路径长度为节点数减1所以此处不加1
         if(root.val == val)   // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
             return Math.max(left,right) + 1;  //因为是一笔画完，不能出现回退
         return 0;
    }

}
