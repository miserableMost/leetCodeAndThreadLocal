package Tree;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/19 8:52
 */
public class TestArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        int l = 0,r = nums.length - 1;
        String ans = "";
        while(l <= r) {
            while(l < r && nums[l] == nums[l + 1]) {
                l ++;
            }
            while(l < r && nums[r] == nums[r - 1]) {
                r --;
            }
            if(nums[l] == nums[r]) {
                ans = ans + nums[l] + ",";
                r --;
                l ++;
            }else if(nums[l] < nums[r]) {
                ans += nums[l] + ",";
                l ++;
            }else {
                ans += nums[r] + ",";
                r --;
            }
        }
        System.out.println(ans.substring(0,ans.length() - 1));

    }
}
