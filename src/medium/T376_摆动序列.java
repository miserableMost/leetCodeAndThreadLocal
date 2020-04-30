package medium;

/**
 * @author 李聪
 * @date 2020/4/12 14:50
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 */
public class T376_摆动序列 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        //记录不是的元素
        int count = 0;
        boolean up = false;

        int index = 1;
        //去掉前面相等的
        while(index < nums.length && nums[index] == nums[index - 1]) {
            index ++;
            count ++;
        }
        if(index == nums.length)
            return nums.length - count;
        if(nums[index] > nums[index - 1]) {
            up = true;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                if(up) {
                    count ++;
                }else {
                    up = !up;
                }
            }else if(nums[i] < nums[i - 1]){
                if(up) {
                    up = !up;
                }else {
                    count ++;
                }
            }else {
                count ++;
            }
        }
        return nums.length - count;
    }
}
