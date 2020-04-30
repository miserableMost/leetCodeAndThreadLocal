package Test.August;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * leetCode 671 : 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 */
public class D14_findSecondMinimumValue_671 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        findSecondMinimumValue(root);
    }
    //广度优先遍历
    public static int findSecondMinimumValue(TreeNode root) {
        int min = Integer.MAX_VALUE;
         Queue<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();  //用于存储
         queue.add(root);
         while(queue.size() != 0){
             int len = queue.size();

             for (int i = 0; i < len; i++) {
                 TreeNode tmp = queue.poll();
                 set.add(tmp.val);
                 if(tmp.left != null)
                     queue.add(tmp.left);
                 if(tmp.right != null)
                     queue.add(tmp.right);
             }
         }
        for (Integer i : set) {
            if(i < min)
                min = i;
        }
        set.remove(min);
        if(set.size() == 0)
            return -1;
        min = Integer.MAX_VALUE;
        for (Integer i : set) {
            if(i < min)
                min = i;
        }
        return min;

    }
}
