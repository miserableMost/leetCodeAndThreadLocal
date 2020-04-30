package medium;

import java.util.HashMap;

/**
 * leetCode 106 ； 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class T106_buildTree_9_7 {
    private int p_idx;
    private int[] inorder;
    private int[] postorder;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        p_idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(0, inorder.length);

    }
    public TreeNode build(int in_left,int in_right) {
        if(in_left == in_right)
            return null;
        int root_val = postorder[p_idx];
        TreeNode root = new TreeNode(root_val);
        p_idx --;
        int index = map.get(root_val);
        //先构建右子树
        root.right = build(index + 1,in_right);
        //再构建左子树
        root.left = build(in_left,index);

        return root;
    }


}
