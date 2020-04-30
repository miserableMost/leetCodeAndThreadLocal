package Test.July;

import java.util.LinkedList;
import java.util.List;

/**
 * leetCode 257:二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Test257_binaryTreePaths {

    public static void main(String[] args) {

    }


    public List<String> binaryTreePaths(TreeNode root) {
         LinkedList<String> res = new LinkedList<>();
         return findAllPaths(root,"",res);

    }
    //定义一个方法
    public static List<String> findAllPaths(TreeNode root, String path, LinkedList<String> paths){
        if (root != null){
            path += Integer.toString(root.val);
            //如果是叶子节点
            if(root.left == null && root.right == null){
                //这条路径已经走完，添加到集合中
                paths.add(path);
            }else{
                //如果是非叶子节点
                path += "->";
                findAllPaths(root.left,path,paths);
                findAllPaths(root.right,path,paths);

            }

        }
        return paths;
    }
}
