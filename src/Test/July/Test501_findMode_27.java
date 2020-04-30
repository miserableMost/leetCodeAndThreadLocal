package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode :二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 *     结点左子树中所含结点的值小于等于当前结点的值
 *     结点右子树中所含结点的值大于等于当前结点的值
 *     左子树和右子树都是二叉搜索树
 */
public class Test501_findMode_27 {

   int max = 0;
   TreeNode pre;
   int cur = 1;
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
          TreeNode root = new TreeNode(1);

          TreeNode n1 = new TreeNode(2);
          TreeNode n2 = new TreeNode(2);
          root.right = n1;
          n1.left = n2;
         /* int[] mode = findMode(root);
          System.out.println(Arrays.toString(mode));*/

    }

    public  int[] findMode(TreeNode root) {
        if(root == null)
            return new int[]{};
        doFind(root);
        int[] arr = new int[list.size()];

        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            a[i]=list.get(i);
        }

        return arr;

    }
    //二叉搜索树是一个升序序列，中序遍历
    public  void doFind(TreeNode root){
        if(root == null){
            return;
        }
        doFind(root.left);

        if(pre != null){
            if(pre.val == root.val){
                cur ++;
            }else{
                cur = 1;
            }
        }
        if(cur == max)
            list.add(root.val);
        if(cur > max){
            list.clear();
            list.add(root.val);
            cur = max;
        }
        pre = root;
        doFind(root.right);
    }

}
