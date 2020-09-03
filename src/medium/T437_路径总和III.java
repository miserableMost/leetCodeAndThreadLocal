package medium;

/**
 * @author 李聪
 * @date 2020/8/7 22:31
 */
public class T437_路径总和III {
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root,int sum){
        if(root == null)
            return 0;
        return pathSum(root,sum) + dfs(root.left,sum) + dfs(root.right,sum);
    }
    public int dfs(TreeNode node,int sum) {
        if(node == null)
            return 0;
        sum -= node.val;
        int result = sum == 0 ? 0 : 1;
        return result + dfs(node.left,sum) + dfs(node.right,sum);
    }
}
