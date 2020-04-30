package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * leerCode 95: 不同的二叉搜索树
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class T95_generateTrees_9_6 {
    public static void main(String[] args) {
        T95_generateTrees_9_6 test = new T95_generateTrees_9_6();
        List<TreeNode> treeNodes = test.generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return geneTree(1,n);
    }
    //生成二叉树
    private LinkedList<TreeNode> geneTree(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        //因为如果 left_trees集合中一个元素都没有的话，在组合的时候不会进入 right_trees 的for循环
        //一旦left大于right，则说明这里无法产生子树，所以此处应该是作为空结点返
        if(start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            //生成左边
            LinkedList<TreeNode> left = geneTree(start, i - 1);
            //生成右边
            LinkedList<TreeNode> right = geneTree(i + 1,end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur_tree = new TreeNode(i);
                    cur_tree.left = l;
                    cur_tree.right = r;
                    res.add(cur_tree);
                }
            }
        }
        return res;
    }
}
