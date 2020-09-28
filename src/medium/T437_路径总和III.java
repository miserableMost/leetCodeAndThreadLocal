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
        return pathSum(root.left,sum) + pathSum(root.right,sum) + dfs(root,sum);
    }
    public int dfs(TreeNode root,int sum){
        if(root == null)
            return 0;
        sum -= root.val;
        int result = sum == 0 ? 1 : 0;
        return result + dfs(root.left,sum) + dfs(root.right,sum);
    }
}
