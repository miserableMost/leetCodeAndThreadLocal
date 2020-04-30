package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 961: 重复N次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 */
public class D5_repeatedNTimes_961 {
    public static void main(String[] args) {

    }
    //由题意得，重复的元素是惟一的
    public int repeatedNTimes(int[] A) {
        /*Map<Integer,Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a,map.getOrDefault(a,0) + 1);
        }
        int len = A.length;
        for (Integer i : map.keySet()) {
            if(map.get(i) == len / 2)
                return i;
        }
        return -1;*/
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int a : A) {
            if(list.contains(a)){
                res = a;
                break;
            }
            list.add(a);
        }
        return res;
    }
}
