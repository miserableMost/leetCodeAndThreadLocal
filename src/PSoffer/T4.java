package PSoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2019/12/19 15:10
 *  根据二叉树的前序和中序遍历，重建二叉树
 *
 * */
public class T4 {
    int pre_idx = 0;
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i],i);
        }
        return conStruct(pre, inMap, 0, pre.length - 1);
    }

    private TreeNode conStruct(int[] pre, Map<Integer, Integer> inMap, int start,int end) {
        if(start > end) {
            return null;
        }
        int root_val = pre[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = inMap.get(root_val);
        pre_idx ++;
        root.left = conStruct(pre,inMap,start,index - 1);
        root.right = conStruct(pre,inMap,index + 1,end);
        return root;
    }
}
