package Test.July;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetCode 637:二叉树的层序遍历
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11]。
 */
public class Test637_averageOfLevels_7_22 {
    public static void main(String[] args) {

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        //定义一个返回结果的集合
        List<Double> res = new ArrayList<>();
        //定义一个集合层序遍历---用于将这一层元素存放于此
        List<TreeNode> q = new LinkedList<>();
        //先将根加入
        q.add(root);
        //每一次while处理一层元素
        while(q.size() > 0){
            double sum = 0;
            int len = q.size();
            //用于将这一层元素遍历，同时将他们移出集合
            for (int i = 0; i < len; i++) {
                //每次都取第一个元素
                root = q.get(0);
                //取完后将它移出集合，这时下一个元素变为第一个元素
                ((LinkedList<TreeNode>) q).removeFirst();
                sum += root.val;
                //下面两步用于将下一层元素存放至q集合
                if(root.left != null){
                    q.add(root.left);
                }
                if(root.right != null){
                    q.add(root.right);
                }

            }
            Double avl = sum / len;
            res.add(avl);
        }
        return res;


    }
}
