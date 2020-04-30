package medium;

/**
 * leetCode 117 : 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 */
public class T117_connect_9_8 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if(root.left != null) {
            if(root.right != null)
                root.left.next = root.right;
            else
                root.left.next = findLeftChild(root);
        }
        if(root.right != null) {
            root.right.next = findLeftChild(root);
        }

        connect(root.right);
        connect(root.left);
        return root;
    }
    //递归：这里注意一定要先构建右子树，再构建左子树，因为寻找父节点的兄弟节点是从左到右遍历的，如果右子树未构建好就遍历，则会出错
    //寻找当前节点的兄弟节点的最左边节点
    private Node findLeftChild(Node root) {
        if(root.next == null)
            return null;
        while(root.next != null) {
            if(root.next.left != null)
                return root.next.left;
            if(root.next.right != null)
                return root.next.right;
            root = root.next;
        }
        return null;
    }
}
