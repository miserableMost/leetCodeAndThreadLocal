package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetCode 199 :二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class T199_rightSideView_9_13 {
    public static void main(String[] args) {

    }
    //二叉树层次遍历--取每层最后一个
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         if(root == null)
             return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.removeFirst();
                if(i == len - 1) {
                    ans.add(temp.val);
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return ans;

    }
}
