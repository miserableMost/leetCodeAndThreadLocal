package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 113 : 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 */
public class T113_pathSum_9_8 {
    List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         pathSum(root,sum,new ArrayList<>());
         return ans;
    }

    public void pathSum(TreeNode root, int sum,List<Integer> cur) {
         if(root == null) {
             return;
         }
         sum -= root.val;
         cur.add(root.val);
         if(root.left == null && root.right == null) {
             if(sum == 0) {
                 ans.add(new ArrayList<>(cur));
             }
         }else { //未到叶子节点
             pathSum(root.left,sum,cur);
             pathSum(root.right,sum,cur);
         }
         cur.remove(cur.size() - 1);


    }
}
