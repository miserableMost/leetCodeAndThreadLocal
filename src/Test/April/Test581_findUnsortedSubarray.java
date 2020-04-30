package Test.April;

import java.util.Arrays;
/*leetCode 581;
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

 */

public class Test581_findUnsortedSubarray {
    public static void main(String[] args) {
        Test581_findUnsortedSubarray test = new Test581_findUnsortedSubarray();
        int[] nums = {12,34,5,66,345,6,64,77,7,7};
        System.out.println("跪了");
        System.out.println(test.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {

        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int i = 0;
        int j = nums.length - 1;
        while(nums[i] == newNums[i] && i<=j)
            i ++;
        while(nums[j] == newNums[j] && i<=j)
            j --;
        System.out.println("i:"+i+"   j:"+j);


        return j-i+1;

    }
}