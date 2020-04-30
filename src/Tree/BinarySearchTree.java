package Tree;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<Integer extends Comparable<? super Integer>> {

    //定义节点
    private static class BinaryNode<Integer>{
        Integer element;
        BinaryNode<Integer> left;
        BinaryNode<Integer> right;
        BinaryNode(Integer theElement){
            this(theElement,null,null);
        }
        BinaryNode(Integer theElement,BinaryNode<Integer> lt,BinaryNode<Integer> rt){
            element = theElement;
            left = lt;
            right = rt;
        }
    }
    //根
    private BinaryNode<Integer> root;
    public BinarySearchTree(){
        root = null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    //判断是否含有
    public boolean contains(Integer x){
        return contains(x,root);
    }
    public Integer findMin(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }
    public Integer findMax(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(Integer x){
        root = insert(x,root);
    }
    public void remove(Integer x){
        root = remove(x,root);
    }
    public void printTree(){

    }
    //查看是否包含
    private boolean contains(Integer x,BinaryNode<Integer> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }
    //找最小值
    private BinaryNode<Integer> findMin(BinaryNode<Integer> t){
        if(t == null)
            return null;
        else if(t.left == null)
            return t;
        return findMin(t.left);
    }
    //找最小值
    private BinaryNode<Integer> findMax(BinaryNode<Integer> t){
        if(t != null)
            while(t.right != null)
                t = t.right;
        return t;
    }
    //添加
    private BinaryNode<Integer> insert(Integer x,BinaryNode<Integer> t){
         if(t == null)
             return new BinaryNode<>(x,null,null);
         int compareResult = x.compareTo(t.element);
         if(compareResult < 0)
             t.left = insert(x,t.left);
         else if(compareResult > 0)
             t.right = insert(x,t.right);
         else
             ;          //重复
         return t;
    }
    //删除
    private BinaryNode<Integer> remove(Integer x,BinaryNode<Integer> t){
         if(t == null)
             return t;
         int compareResult = x.compareTo(t.element);
         if(compareResult < 0)
             t.left = remove(x,t.left);
         else  if(compareResult > 0)
             t.right = remove(x,t.right);
         //有两个孩子，用其右子树最小的数据代替该节点的数据并递归地删除那个节点
         //阅读递归函数最容易的方法不是纠缠于它的执行过程，而是相信递归函数会顺利完成它的任务。
         else if(t.left != null && t.right != null){
             t.element = findMin(t.right).element;
             t.right = remove(t.element,t.right);
         }
         else
             t = (t.left != null) ? t.left:t.right;
         return t;
    }
    private void printTree(BinaryNode<Integer> t){

    }

}
