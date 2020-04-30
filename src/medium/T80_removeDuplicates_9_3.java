package medium;

/**
 * leetCode 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class T80_removeDuplicates_9_3 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums,2);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    //最多可以重复k个
    public static int removeDuplicates(int[] nums,int k) {
        int i = 0; //标识数组的下标
        for (int num : nums) {
            if(i < k || num > nums[i - k]){ //牛逼
                nums[i ++] = num;
            }
        }
        return i;
    }
}
