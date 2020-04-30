package findJob.second.gcroots;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author 李聪
 * @date 2020/1/25 14:15
 */
public class WeahHashMapDemo {
    public static void main(String[] args) {
        myWeakHashMap();
    }
    private static void myHashmap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
