package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/2/28 22:34
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class T18_fourSum {
    public static void main(String[] args) {
        int[] sum = {1, 0, -1, 0, -2, 2};
        T18_fourSum t = new T18_fourSum();
        List<List<Integer>> ans = t.fourSum(sum, 0);
        for (List<Integer> a : ans) {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null || nums.length < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j -1])
                    continue;
                int left = j + 1,right = nums.length - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target) {
                        left ++;
                    }else if(sum > target) {
                        right --;
                    }else {
                        ans.add(Arrays.asList(nums[i], nums[j] , nums[left] , nums[right]));
                        while(left < right && nums[left] == nums[left ++]);
                        while(left < right && nums[right] == nums[right --]);
                    }
                }
            }
        }
        return ans;
    }
}
