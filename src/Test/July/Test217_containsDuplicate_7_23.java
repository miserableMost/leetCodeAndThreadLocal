package Test.July;

import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 217:存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Test217_containsDuplicate_7_23 {
    public static void main(String[] args) {
        int[] res = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(res));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果set里含有这个值,则返回true
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
