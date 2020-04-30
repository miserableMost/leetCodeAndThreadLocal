package Tree;

public class AVLTree<Integer extends Comparable<? super Integer>> {

    //定义AVL树的节点
    private static class AvlNode<Integer>{
        Integer element;
        AvlNode<Integer> left;
        AvlNode<Integer> right;
        int height;
        AvlNode(Integer theElement){
            this(theElement,null,null);
        }
        AvlNode(Integer theElement,AvlNode<Integer> lt,AvlNode<Integer> rt){
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }
    //计算Avl节点的高度的方法
    private int height(AvlNode<Integer> t){
        return t == null ? -1 : t.height;
    }
    //插入例程
    private AvlNode<Integer> insert(Integer x,AvlNode<Integer> t){
        if(t == null)
            return new AvlNode<>(x,null,null);
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0)
            t.left = insert(x,t.left);
        else if(compareResult > 0)
            t.right = insert(x,t.right);
        else
            ;
        return balance(t);
    }
    public static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<Integer> balance(AvlNode<Integer> t){
        if(t == null)
            return t;
        if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE){
            if(height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        }else if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
            if(height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.left),height(t.right)) + 1;
        return t;
    }
    //单旋转-左
    private AvlNode<Integer> rotateWithLeftChild(AvlNode<Integer> k2) {
        AvlNode<Integer> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left),k2.height) + 1;
        return k1;
    }
    //单旋转-右
    private AvlNode<Integer> rotateWithRightChild(AvlNode<Integer> k1) {
        AvlNode<Integer> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left),height(k1.right)) + 1;
        k2.height = Math.max(k1.height,height(k2.right)) + 1;
        return k2;
    }
    //左-右双旋转
    private AvlNode<Integer> doubleWithLeftChild(AvlNode<Integer> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    //右-左双旋转
    private AvlNode<Integer> doubleWithRightChild(AvlNode<Integer> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
    private AvlNode<Integer> remove(Integer x,AvlNode<Integer> t){
        if(t == null)
            return t;
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0)
            t.left = remove(x,t.left);
        else if(compareResult > 0)
            t.right = remove(x,t.right);
        else if(t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    private AvlNode<Integer> findMin(AvlNode<Integer> t){
        if(t == null)
            return null;
        else if(t.left == null)
            return t;
        return findMin(t.left);
    }



}
