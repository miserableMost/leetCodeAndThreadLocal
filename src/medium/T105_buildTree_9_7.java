package medium;

import java.util.HashMap;

/**
 * leetCode 105 : 从前序和中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7

 */
public class T105_buildTree_9_7 {
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static void main(String[] args) {

    }
    //中序：左-中-右
    //前序：中-左-右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //将中序遍历存储起来
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        this.preorder = preorder;
        this.inorder = inorder;

        return build(0,inorder.length);

    }

    private TreeNode build(int in_left ,int in_right) {
         if(in_left == in_right)
             return null;
         int root_val = preorder[pre_index];
         TreeNode root = new TreeNode(root_val);
         int index = map.get(root_val);
         pre_index ++;
         //左闭右开--mid被检测之后，分割成两个区间[left, mid) 或 [mid + 1, right)。
         //构建左子树
         root.left = build(in_left,index);
         //构建右子树
         root.right = build(index + 1,in_right);
         return root;
    }
}
