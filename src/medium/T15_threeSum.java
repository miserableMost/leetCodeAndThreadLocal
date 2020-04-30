package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/2/28 21:32
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class T15_threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,4};
        T15_threeSum test = new T15_threeSum();
        List<List<Integer>> ans = test.threeSum(nums);
        for (List<Integer> a : ans) {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    //主要是去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        int left = 0,right = nums.length - 1,sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) {
                    right --;
                }else if(sum < 0) {
                    left ++;
                }else {
                    //针对可能选中的点
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1])
                        left ++;
                    while(left < right && nums[right] == nums[right -1])
                        right --;
                    left ++;
                    right --;
                }
            }
        }
        return res;
    }
}
