package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 594 :最长和谐字序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 */
public class D2_findLHS_594 {
    public static void main(String[] args) {

    }
    public int findLHS(int[] nums) {
        Map<Integer,Integer> res = new HashMap<>();
        //将数组元素及出现次数存在res集合中
        for (int num : nums) {
            res.put(num,res.getOrDefault(num,0) + 1);
        }
        int max = 0;
        //遍历map,求出值相差为1的两元素个数之和最大的
        for (Integer key : res.keySet()) {
            if(res.containsKey(key + 1)){
                max = Math.max(res.get(key) + res.get(key + 1),max);
            }
        }
        return max;
    }
}
