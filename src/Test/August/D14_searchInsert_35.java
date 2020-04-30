package Test.August;

/**
 * leetCode 35:搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class D14_searchInsert_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //如果target比第一个还小
            if(target < nums[0])
                return 0;
            //找到了
            if(nums[i] == target){
                return i;
            }
            //比当前大比后面的小，插入其中
            if(i + 1 < len && (target > nums[i] && target < nums[i + 1])){
                return i + 1;
            }

        }
        //插到最后一位
        return len;
    }
}
