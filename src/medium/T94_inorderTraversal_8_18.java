package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 94 : 二叉树的中序遍历
 */
public class T94_inorderTraversal_8_18 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        inorderTraversal(root);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            //先打到左边最底下
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //已经达到左子树最下面
            if(! stack.isEmpty()){
                cur = stack.pop();
                list.add(cur.val);
                System.out.print(cur.val + "->");
                cur = cur.right;
            }

        }
        return list;
    }
}
