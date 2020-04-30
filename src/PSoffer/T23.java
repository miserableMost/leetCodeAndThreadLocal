package PSoffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 李聪
 * @date 2019/12/22 15:37
 */
public class T23 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(7);
        TreeNode r4 = new TreeNode(12);
        TreeNode r5 = new TreeNode(10);
        r1.left = r2;
        r2.left = r3;
        r1.right = r4;
        T23 t = new T23();
        ArrayList<ArrayList<Integer>> arrayLists = t.FindPath(r1, 22);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        paths(res,root,target,new ArrayList<Integer>());
        res.sort(Comparator.comparingInt(list -> -list.size()));
        return res;
    }

    private void paths(ArrayList<ArrayList<Integer>> res, TreeNode root, int target, ArrayList<Integer> cur) {
        if(root == null)
            return;
        cur.add(root.val);
        if(root.left == null && root.right == null) {
            if(target == root.val) {
                res.add(new ArrayList<>(cur));
            }
        }else {
            paths(res,root.left,target - root.val,cur);
            paths(res,root.right,target - root.val,cur);
        }
        cur.remove(cur.size() - 1);
    }


}
