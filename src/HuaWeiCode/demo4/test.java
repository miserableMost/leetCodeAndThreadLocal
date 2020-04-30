package HuaWeiCode.demo4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Node ndoe = new Node(1);
        Set<Node> set = new HashSet<>();
        set.add(ndoe);
        System.out.println(set.contains(ndoe));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Node no = (Node) iterator.next();
            System.out.println(set.contains(no));
        }

    }

}
