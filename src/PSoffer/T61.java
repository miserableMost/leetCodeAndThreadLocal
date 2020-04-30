package PSoffer;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2019/12/30 14:58
 */
public class T61 {

    /*private int index = 0;

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t5.left = t3;
        t5.right = t7;
        t3.left = t2;
        t3.right= t4;
        t7.left = t6;
        t7.right = t8;
        T61 t61 = new T61();
        TreeNode ans = t61.KthNode(t5, 3);
        System.out.println(ans.val);
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null)
            return null;
        //如果在左子树中找到
        TreeNode pLeft = KthNode(pRoot.left, k);
        if(pLeft != null)
            return pLeft;
        if((++ index ) == k){
            return pRoot;
        }
        TreeNode pRight = KthNode(pRoot.right, k);
        if(pRight != null)
            return pRight;
        return null;
    }*/
    //非递归中序遍历
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k == 0)
            return null;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || pRoot != null) {
            while(pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            if(++count == k)
                return pRoot;
            pRoot = pRoot.right;
        }
        return null;
    }


}
