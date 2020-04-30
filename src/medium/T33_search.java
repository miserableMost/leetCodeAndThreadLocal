package medium;

/**
 * leetCode 33:搜索旋转排列数组
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 */
public class T33_search {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //前半部分有序
            if(nums[start] <= nums[mid]) {
                //target在前半部分
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                //target在后半部分
                if(target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
