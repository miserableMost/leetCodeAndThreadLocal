package medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class T173_BSTIterator_8_18 {
    public static void main(String[] args) {

    }

    Queue<Integer> queue = new PriorityQueue<>();
    public T173_BSTIterator_8_18(TreeNode root) {
        dfs(root);
    }
    //中序遍历获得从小到大的队列
    private void dfs(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null)
            dfs(root.left);
        queue.add(root.val);
        if(root.right != null)
            dfs(root.right);
    }

    /** @return the next smallest number */
    public int next() {
         return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }


}
