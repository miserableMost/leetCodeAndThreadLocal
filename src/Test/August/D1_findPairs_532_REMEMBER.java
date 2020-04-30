package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 532 数组中的k-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 */
public class D1_findPairs_532_REMEMBER {
    public static void main(String[] args) {
         int[] nums = {3, 1, 4, 1, 5};
         int k = 2;
         int pairs = findPairs(nums, k);
         System.out.println(pairs);
    }
    public static int findPairs(int[] nums, int k) {
        //nums为空，长度小于2，或者k小于0等都视为非法，直接返回0
        if(nums==null || nums.length<2 || k<0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            //map中存储每个数字及其出现的次数
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Integer i : map.keySet()) {
            if(k == 0){
                //两个相同的数满足题意
                if(map.get(i) > 1)
                    count ++;
                //计算较小的值加上k后是否有较大的对应
                //等价于较大和较小绝对值之和--只计算一对
            }else if(map.containsKey(i + k))
                count ++;
        }
        return count;
    }
}
