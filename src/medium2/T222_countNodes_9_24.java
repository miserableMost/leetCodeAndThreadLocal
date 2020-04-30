package medium2;

import newTest.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入: 
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class T222_countNodes_9_24 {
    public static void main(String[] args) {

    }
    public int countNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.removeFirst();
                ans.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return ans.size();
    }
    /**
     完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     判断左右子树的高度:
     如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
     如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
     **/
    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld == rd)
            return (1 << ld) + countNodes2(root.right);  // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        else
            return (1 << rd) + countNodes2(root.left);  // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth ++;
            root = root.left;
        }
        return depth;
    }
}
