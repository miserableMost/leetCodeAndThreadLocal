package PSoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/30 12:48
 */
public class T58 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(pRoot == null)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean zuo = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(zuo) {
                    list.addLast(cur.val);
                }else {
                    list.addFirst(cur.val);
                }
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            ans.add(new ArrayList<>(list));
            zuo = zuo == true ? false : true;
        }
        return ans;
    }
}
