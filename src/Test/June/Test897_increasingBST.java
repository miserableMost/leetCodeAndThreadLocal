package Test.June;

import java.util.ArrayList;
import java.util.List;

public class Test897_increasingBST {
    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         list = inorderTraversal(root,list);
         //集合中的第一个元素即为根
         TreeNode currentNode = new TreeNode(list.get(0));
         TreeNode result = currentNode;
        for (int i = 0; i < list.size(); i++) {
            //只存在右节点
            currentNode.right = new TreeNode(list.get(i));
            currentNode = currentNode.right;
        }
        return  result;
    }
    //递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> list){
           if(root != null){
               //左子树
               inorderTraversal(root.left,list);
               //根
               list.add(root.val);
               //右子树
               inorderTraversal(root.right,list);
           }
           return list;
    }
}
