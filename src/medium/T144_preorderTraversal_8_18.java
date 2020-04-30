package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 144 : 二叉树的前序遍历
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class T144_preorderTraversal_8_18 {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
           return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null)
                stack.add(temp.right);
            if(temp.left != null)
                stack.add(temp.left);
        }
        return list;
    }
}
