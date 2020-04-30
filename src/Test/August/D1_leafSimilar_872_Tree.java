package Test.August;

import java.util.ArrayList;
import java.util.List;

public class D1_leafSimilar_872_Tree {
    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
          sort(root1,res1);
          sort(root2,res2);
        /*if(res1.size()!=res2.size()) return false;
        for(int i = 0;i<res1.size();i++){
            if(res1.get(i)!= res2.get(i)){
                return false;
            }
        }

        return true;*/
        //判断两个集合是否相等
        return res1.equals(res2);


    }
    public void sort(TreeNode root,List<Integer> res){
        //一定要看当前root是否为空
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res.add(root.val);
        }
        sort(root.left,res);
        sort(root.right,res);

    }
}
