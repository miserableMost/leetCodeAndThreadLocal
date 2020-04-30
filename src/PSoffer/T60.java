package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 21:05
 */
public class T60 {
    private int index = -1;
    public static void main(String[] args) {

    }
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index ++;
        int len = str.length();
        if(index >= len) {
            return null;
        }
        String[] strArr = str.split(",");
        TreeNode node = null;
        if(!strArr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strArr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
