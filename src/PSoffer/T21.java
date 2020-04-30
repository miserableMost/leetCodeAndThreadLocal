package PSoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/22 15:05
* 二叉树层次遍历
 */
public class T21 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
