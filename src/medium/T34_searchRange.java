package medium;

/**
 * leetCode 34 : 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class T34_searchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        T34_searchRange test = new T34_searchRange();
        test.searchRange(nums,8);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        return new int[]{searchLeft(nums,target),searchRight(nums,target)};
    }

    public int searchLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) >>> 1;
            //向左边收缩
            if(nums[mid] == target) right = mid;
            else if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid;
        }
        //// target 比所有数都大
        int pos = (left < nums.length)?left:nums.length-1;
        if(nums[pos] != target) return -1;
        return left;
    }

    public int searchRight(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) >>> 1;
            //向右收缩
            if(nums[mid] == target) left = mid + 1;
            else if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid;
        }
        //又因为收紧左侧边界时必须 left = mid + 1
        //所以最后无论返回 left 还是 right，必须减一
        int pos = (left - 1 >= 0)? left-1:0;
        if(nums[pos] != target) return -1;
        return left - 1;
    }
}
