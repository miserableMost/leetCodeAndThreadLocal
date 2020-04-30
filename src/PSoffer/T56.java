package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 12:27
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class T56 {
    public static void main(String[] args) {

    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;
        //如果有右子树，找到右子树的最左节点
        if(pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null) {  //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
