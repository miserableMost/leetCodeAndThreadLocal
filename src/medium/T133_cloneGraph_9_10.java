package medium;

/**
 * leetCode 133 : 克隆图
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 */
public class T133_cloneGraph_9_10 {
    public static void main(String[] args) {

    }
    /*public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Map<Integer,Node> map = new HashMap<>();
        return help(node,map);
    }

    private Node help(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        //生成当前节点
        Node n = new Node();
        n.val = node.val;
        n.neighbors = new ArrayList<Node>();
        //放入map中
        map.put(node.val,n);
        //添加它的所有邻居节点
        for (Node temp : node.neighbors) {
            n.neighbors.add(help(temp,map));
        }
        return n;
    }*/
}


