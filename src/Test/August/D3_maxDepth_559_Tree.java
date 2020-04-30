package Test.August;

import java.util.List;

/**
 * leetCode 559: N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 */
public class D3_maxDepth_559_Tree {

    public static void main(String[] args) {

    }
    public int maxDepth(Node root) {
        int max = 0;
        if(root == null)
             return 0;
        List<Node> child = root.children;

        for (Node node : child) {
            //求出每个子树的最大深度
            int temp = maxDepth(node);
            //动态替换
            max = Math.max(max,temp);
        }
        return max + 1;
    }
}
