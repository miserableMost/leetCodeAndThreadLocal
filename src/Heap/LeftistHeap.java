package Heap;
//堆
public class LeftistHeap<Integer extends Comparable<? super Integer>> {

    private Node<Integer> root;
    public LeftistHeap() {
        root = null;
    }

    public  boolean isEmpty(){
        return root == null;
    }
    public void makeEmpty(){
        root = null;
    }

    private static class Node<Integer>{
        Node(Integer theElement){
            this(theElement,null,null);
        }
        Node(Integer theElement,Node<Integer> lt,Node<Integer> rt){
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }
        Integer element;
        Node<Integer> left;
        Node<Integer> right;
        int npl;
    }

    public void merge(LeftistHeap<Integer> rhs){
        if(this == rhs)
            return;
        root = merge(root,rhs.root);
        rhs.root = null;
    }

    private Node<Integer> merge(Node<Integer> h1,Node<Integer> h2){
        if(h1 == h2)
            return h2;
        if(h2 == null)
            return h1;
        if(h1.element.compareTo(h2.element) < 0)
            return merge1(h1,h2);
        else
            return merge1(h2,h1);
    }
    private Node<Integer> merge1(Node<Integer> h1,Node<Integer> h2){
        if(h1.left == null)
            h1.left = h2;
        else{
            h1.right = merge(h1.right,h2);
            if(h1.left.npl < h1.right.npl)
                swapChildren(h1);
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<Integer> t) {

    }
}
