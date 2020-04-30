package Test.August;

/**
 * leetCode 27:移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class D12_removeElement_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = removeElement(nums, 2);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[index ++] = nums[i];
            }
        }

        return index;
    }
}
