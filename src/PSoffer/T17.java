package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/22 10:47
 * 镜像二叉树
 */
public class T17 {
    public static void main(String[] args) {

    }
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        //将其左右节点交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.right);
        Mirror(root.left);
    }
}
