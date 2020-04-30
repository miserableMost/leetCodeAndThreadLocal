package Test.August;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetCode 970 : 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 *
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 *
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 */
public class D11_powerfulIntegers_970 {
    public static void main(String[] args) {
        List<Integer> integers = powerfulIntegers(2, 1, 10);
        for (Integer i : integers) {
            System.out.print(i+" ");
        }
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                //y为1的话只能给干一波
                if(y == 1)
                    break;
            }
            if(x == 1)
                break;
        }
        return new ArrayList<>(set);
    }
}
