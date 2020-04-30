package hard.ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/4/9 21:58
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class T442_数组中重复的数字_记住 {
    public static void main(String[] args) {
        int[] ans = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(ans);
        for (Integer d : duplicates) {
            System.out.print(d + " ");
        }
    }
    //输入输出的空间不属于额外空间，可以在输入数组中用数字的正负来表示该位置所对应数字是否已经出现过。
    // 遍历输入数组，给对应位置的数字取相反数，如果已经是负数，说明前面已经出现过，直接放入输出数组。
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }else {
                ans.add(num);
            }
        }
        return ans;

    }
}
