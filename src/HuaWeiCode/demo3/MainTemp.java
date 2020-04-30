package HuaWeiCode.demo3;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/3 15:43
 */


public class MainTemp {
    //定义一个节点
    class Node {
        private int val;
        private Set<Node> toSet;
        private int inDegree;
        private int outDegree;




        public Node(int val, Set<Node> toSet, int inDegree, int outDegree) {
            this.val = val;
            this.toSet = toSet;
            this.inDegree = inDegree;
            this.outDegree = outDegree;
        }
    }

    private Set<Node> startNode = new TreeSet<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    });

    public void generateGraph(ArrayList<String> list) {
        for (String str : list) {
            int indx1 = 0;
            while (str.charAt(indx1) != ',') indx1++;
            int indx2 = indx1 + 1;
            while (str.charAt(indx2) != ',') indx2++;
            int from = Integer.valueOf(str.substring(0, indx1));
            int to = Integer.valueOf(str.substring(indx1 + 1, indx2));
            Set<Node> set;
            Node curNode = new Node(from, new HashSet<>(), 0, 0);
            if (startNode.contains(curNode)) {
                Iterator<Node> it = startNode.iterator();
                while(it.hasNext()) {
                    Node cur = it.next();
                    if(cur.val == from) {
                        set = cur.toSet;

                    }
                }
            }
        }


    }
}
