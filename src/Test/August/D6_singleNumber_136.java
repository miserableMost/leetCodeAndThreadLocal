package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 136 : 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 *
 */
public class D6_singleNumber_136 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Integer i : map.keySet()) {
            if(map.get(i) == 1)
                return i;
        }
        return -1;
    }
}
