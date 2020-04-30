package medium;

/**
 * leetCode 81 : 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false
 *
 */
public class T81_search_9_4 {
    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else if(nums[start] == nums[mid]) {
                start++;
            } else {
                //target在后半部分
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }


            }
        }
        return false;
    }
}
