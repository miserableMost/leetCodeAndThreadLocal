package PSoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/30 13:08
 */
public class T59 {
    public static void main(String[] args) {

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(pRoot == null)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
