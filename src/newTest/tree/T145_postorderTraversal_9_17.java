package newTest.tree;

import newTest.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历
 */
public class T145_postorderTraversal_9_17 {
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        //从前序的中-左-右变成中-右-左，利用栈倒序，为左-右-中后序遍历
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            ans.addFirst(cur.val);
            if(cur.left != null) {
                s.add(cur.left);
            }
            if(cur.right != null) {
                s.add(cur.right);
            }
        }

        return ans;
    }
}
