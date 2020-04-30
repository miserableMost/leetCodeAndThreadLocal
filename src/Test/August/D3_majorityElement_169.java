package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 169:求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class D3_majorityElement_169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
         int len = nums.length;
         Map<Integer,Integer> map = new HashMap<>();
         for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
         }
        for (Integer i : map.keySet()) {
            if(map.get(i) > len / 2)
                return i;
        }
        return -1;

    }
}
