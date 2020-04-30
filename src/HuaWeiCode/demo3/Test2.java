package HuaWeiCode.demo3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 李聪
 * @date 2020/4/3 16:55
 */
public class Test2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        set.add(1);
        graph.put(0,set);
        set.add(2);
    }
}
