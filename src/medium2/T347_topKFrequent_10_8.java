package medium2;

import java.util.*;

/**
 * leetCode 347 : 前k个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *示例 1:
 *输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *示例 2:
 *输入: nums = [1], k = 1
 * 输出: [1]
 *说明：
 *你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class T347_topKFrequent_10_8 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        T347_topKFrequent_10_8 test = new T347_topKFrequent_10_8();
        List<Integer> list = test.topKFrequent(nums, 2);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        //创建小顶堆-小的都被顶出去了，留下来的就是大的
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)-> map.get(n1) - map.get(n2));
        for (Integer n : map.keySet()) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> ans = new LinkedList<>();
        while(!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
