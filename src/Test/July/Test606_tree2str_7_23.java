package Test.July;

/**
 * leetCode 606: 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间
 * 的一对一映射关系的空括号对。
*/
public class Test606_tree2str_7_23 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        String s = tree2str(root);
        System.out.println(s);
    }
    //前序遍历 ：父——左——右
    public static String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if(t == null)
            return sb.toString();
        doTree2Str(t,sb);
        return sb.toString();
    }

    public static void doTree2Str(TreeNode t,StringBuilder s){
         if(t == null){
             return;
         }
         s.append(t.val);
         if(t.left != null){
             s.append("(");
             doTree2Str(t.left,s);
             s.append(")");
         }else if(t.left == null && t.right != null){
             s.append("()");
         }
         if(t.right != null){
             s.append("(");
             doTree2Str(t.right,s);
             s.append(")");
         }

    }
}
