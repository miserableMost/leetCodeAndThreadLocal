package medium2;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 560 : 和为k的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 *
 *     数组的长度为 [1, 20,000]。
 *     数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class T560_subarraySum_10_8 {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        //map确保当map的right和left一起时，结果有1
        ////初始化，表示和为0的从index=0开始连续子序列有1个
        //最开始得到k
        //用来统计直接加出sum的情况，这时候sum-k就会找到0的位置
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k))
                ret += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ret;
    }
}
