package medium;

/**
 * @author 李聪
 * @date 2020/4/14 22:39
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 *
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 *
 *
 * 示例 1：
 *
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 *
 * 示例 2：
 *
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 *
 * 示例 3:
 *
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。
 */
public class T457_环形数组循环_记住技巧 {
    public static void main(String[] args) {

    }
    //检测是否有环用快慢指针
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums == null) return false;//处理特殊情况
        for (int i = 0; i < nums.length; i++) {
            int j = i,k = next(nums,i);
            //快慢指针必须向着同一个方向移动
            while(nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0 && nums[i] * nums[next(nums,k)] > 0) {
                if(j == k) {
                    //快慢指针相遇
                    if(j == next(nums,j))
                        break;
                    return true;
                }
                //移动慢指针
                j = next(nums,j);
                //移动快指针
                k = next(nums,next(nums,k));
            }
        }
        return false;
    }

    private int next(int[] nums,int i) {
        int next = nums[i] + i;
        if(next < 0)
            return nums.length + next%nums.length;  //下一个一定是负数
        else
            return next % nums.length;
    }
}
