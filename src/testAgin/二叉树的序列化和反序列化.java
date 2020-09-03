package testAgin;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/6/27 23:36
 */
public class 二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> a = new HashSet<>();
        list.add(10);
        list.add(11);
        arr.add(12);
        arr.add(13);
        System.out.println(arr.get(1));
        System.out.println(list.get(0));
    }
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    private String rserialize(TreeNode root, String str) {
        if(root == null) {
            str += "Null,";
        }else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(arr));
        return rdeserialize(list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if(list.get(0).equals("Null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }
}
