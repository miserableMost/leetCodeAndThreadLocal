package testAgin;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/6/27 15:59
 */
public class 恢复二叉树 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.poll();
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        recoverTree(root);

    }
    public static void recoverTree(TreeNode root) {
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode fir = null;
        TreeNode sec = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                if(fir == null && pre.val > root.val) {
                    fir = pre;
                }
                if(fir != null && pre.val > root.val) {
                    sec = root;
                }
                pre = root;
                root = root.right;
            }

        }
        int temp = fir.val;
        fir.val = sec.val;
        sec.val = temp;
    }
}
class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + "";
    }
}