package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/22 10:18
 */
public class T16 {
    public static void main(String[] args) {

    }
    //首先判断两个数是否相等
    private boolean isEqual(TreeNode l,TreeNode r) {
        if(l == null && r == null)
            return true;
        if(l == null || r == null)
            return false;
        if(l.val == r.val) {
            return isEqual(l.left,r.left) && isEqual(l.right,r.right);
        }
        return false;
    }
    public boolean isSub(TreeNode s,TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        //根节点相同,两个树直接相等
        return isEqual(s,t) || isSub(s.left,t) || isSub(s.right,t);


    }
}
