package newTest.tree;

import newTest.TreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class T230_kthSmallest_9_17 {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        ArrayList<Integer> ans = new ArrayList<>();
        infixOrder(root,ans);
        return ans.get(k);
    }

    private void infixOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;
        if(root.left != null) {
            infixOrder(root.left,list);
        }
        list.add(root.val);
        if(root.right != null) {
            infixOrder(root.right, list);
        }
    }


   /* class Solution {
        private int i = 0;
        private int val = 0;
        public int kthSmallest(TreeNode root, int k) {
            ldr(root, k);
            return val;

        }

        public void ldr(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            ldr(root.left, k);
            i ++;
            if (k == i) {
                val = root.val;
                return;
            }
            ldr(root.right, k);
        }

    }
*/

}
