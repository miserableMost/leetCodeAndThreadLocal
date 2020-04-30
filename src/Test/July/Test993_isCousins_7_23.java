package Test.July;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 993: 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 */
public class Test993_isCousins_7_23 {
    //定义两个map
    Map<Integer,Integer> depth;   //存放每个节点的深度
    Map<Integer,TreeNode> par;       //存放每个节点的父亲

    public static void main(String[] args) {

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        par = new HashMap<>();
        doIsCousins(root,null);
         return (depth.get(x) == depth.get(y) && par.get(x) != par.get(y));

    }
    public void doIsCousins(TreeNode node,TreeNode parent){
        if(node != null){
            depth.put(node.val,parent == null ? 0 :depth.get(parent.val) + 1);
            par.put(node.val,parent);
            doIsCousins(node.left,node);
            doIsCousins(node.right,node);
        }
    }
}
