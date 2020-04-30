package medium;
/**
 * leetCode 102 : 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
import java.util.*;

public class T102_levelOrder_9_7 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() > 0) {
            int len = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                cur.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            ans.add(cur);


        }
        return ans;
    }
}
