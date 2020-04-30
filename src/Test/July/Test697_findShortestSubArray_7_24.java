package Test.July;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 697: 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素
 * 出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
。
 */
public class Test697_findShortestSubArray_7_24 {

    public static void main(String[] args) {
         int[] nums = {1, 2};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
         //定义一个map用计数
         Map<Integer,Integer> map = new HashMap<>();
         //定义最大的度
         int maxDu = 0;
         //定义最小的长度
        int min = Integer.MAX_VALUE;
         //定义一个map获取起始的位置
        Map<Integer,Integer> start = new HashMap<>();
        //获取这个数的终止位置
        Map<Integer,Integer> end = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                start.put(nums[i],i);
            }else{
                int index = map.get(nums[i]);
                map.put(nums[i],index + 1);
            }
            //为防止空指针异常，每次都必须记录终止位置
            end.put(nums[i],i);
            //获得最大的度
            maxDu = Math.max(maxDu,map.get(nums[i]));
        }
        //最大的可能来自不同的子数组，须循环求出其中最小的
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxDu){
                //获取最大的度对应的key
                int m = entry.getKey();
                //获得对应的最小长度
                min = Math.min(min,end.get(m) - start.get(m) + 1);
            }
        }
       /* int s = start.get(index);
        int e = end.get(index);*/
        return min;


    }
}
