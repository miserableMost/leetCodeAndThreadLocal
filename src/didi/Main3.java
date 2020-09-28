package didi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李聪
 * @date 2020/9/13 18:37
 */
public class Main3 {
    public static void main(String[] args) {
        Set<Integer> m = new HashSet<>();
        m.add(10);
        m.add(10);
        for (Integer i : m) {
            System.out.println(i);
        }
        //Scanner sc = new Scanner(System.in);
    }
}
