package Test.July;

import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 219:存在重复元素\\
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k
 示例 1:
 输入: nums = [1,2,3,1], k = 3
 输出: true
 示例 2:
 输入: nums = [1,0,1,1], k = 1

 */
public class Test219_containsNearbyDuplicate_7_23_REMEMBER {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            //维持列表的元素为k个，若超过k个则移除最前面一个
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}
