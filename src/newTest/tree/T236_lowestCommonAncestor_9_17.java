package newTest.tree;

import newTest.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 */
public class T236_lowestCommonAncestor_9_17 {

    private TreeNode cur;

    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       /* //使用层次遍历
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        queue.push(root);
        //直到找到p和q
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                parent.put(cur.left, cur);
                queue.push(cur.left);
            }
            if(cur.right != null) {
                parent.put(cur.right, cur);
                queue.push(cur.right);
            }
        }
        //设置一个集合存储p的所有父亲及祖父
        Set<TreeNode> ans = new HashSet<>();
        while(p != null) {
            ans.add(p);
            p = parent.get(p);
        }
        while(!ans.contains(q)) {
            q = parent.get(q);
        }
        return q;*/
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;



    }
}
