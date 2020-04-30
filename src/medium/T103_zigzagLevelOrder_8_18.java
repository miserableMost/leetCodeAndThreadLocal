package medium;

import java.util.*;

public class T103_zigzagLevelOrder_8_18 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int count = 0;  //表示第几层
        //记录是否反转
        //boolean isReverse = false;
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<Integer>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if(count % 2 == 0){
                    list.add(temp.val);
                }else{
                    list.addFirst(temp.val);
                }

                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }

            }
            res.add(list);
            count ++;
        }
        return res;
    }
}
