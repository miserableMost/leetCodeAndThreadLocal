package tryTest;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/7/21 22:50
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4,10,9};
        int[] height = height(nums);
        System.out.println(Arrays.toString(height));
    }
    public static int[] height(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
     }
}
