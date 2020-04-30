package HuaWeiCode.demo8;

import java.util.TreeSet;

public class Node implements Comparable<Node>{

    private int val;            //节点值
    private TreeSet<Node> toSet;    //指向节点集合
    private int indegree;       //入度

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeSet<Node> getToSet() {
        return toSet;
    }

    public void setToSet(TreeSet<Node> toSet) {
        this.toSet = toSet;
    }

    public int getIndegree() {
        return indegree;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }



    @Override
    public boolean equals(Object o) {

        Node node = (Node) o;
        if(this.getVal()==node.getVal()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getVal();
    }

    @Override
    public int compareTo(Node o) {
        if(this.val==o.val) return 0;
        return this.val<o.getVal()? -1 : 1;
    }
}
