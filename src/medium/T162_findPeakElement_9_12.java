package medium;

/**
 * leetCode 162 : 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 */
public class T162_findPeakElement_9_12 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int i = findPeakElement(nums);
        System.out.println(i);
    }
    //只需满足nums[i] > nums[i + 1]
    public static int findPeakElement(int[] nums) {
          int left = 0;
          int right = nums.length - 1;
          int mid = 0;
          while(left < right) {
              mid = left + (right - left) / 2;
              if(nums[mid] > nums[mid + 1]) {
                  right = mid;
              }else {
                  left = mid + 1;
              }
          }
          return left;
    }
}
