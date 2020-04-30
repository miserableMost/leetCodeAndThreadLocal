package Test.July;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetCode107: 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *

 */
public class Test107_levelOrderBottom_7_22_Tree {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            //定义一个list用于存储每一层的数据
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                //从q弹出的数据
                root = q.poll();
                //list记录下来
                list.add(root.val);
                //将下一层的数据添加入q
                if(root.left != null){
                    q.add(root.left);
                }
                if(root.right != null){
                    q.add(root.right);
                }


            }
            res.addFirst(list);


        }
        return res;
    }
}
