package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/4/23 17:16
 */
public class Test12 {
    public static void main(String[] args) {

    }
    private static int getMax(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 0;

        for(int i = len - 3;i >= 0;i --) {
            if(nums[i] + nums[i + 1] > nums[i + 2]) {
                ans = Math.max(nums[i] + nums[i + 1] + nums[i + 2],ans);
            }
        }
        return ans;
    }
    public int[] get() {
        Map<Integer,Integer> map = new HashMap<>();

        return new int[]{};
    }
}
