package Test.October;

/**
 * leetCode 334.递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 *     如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *     使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Test334_increasingTriplet_10_20 {
    public static void main(String[] args) {
        int[] nums = {2,4,-2,-3};
        increasingTriplet(nums);
    }

    /**
     * 这道题给我的时候，我是没有思路的，上网看了一遍答案，发现虽然大家都写出来了最终的算法，但是还没人聊聊这道题，为什么是用这个解法，尤其是为什么这种解法能保证所有的情况。
     *
     * 先说下这道题的思路： 首先找到一个相对小的值，然后找到比这个小一点的值大的值(中间值)，然后看能够在最后找到比中间值大的值。
     *
     * 我来说下为什么这种思路能保证覆盖所有的情况。
     *
     * 首先，如果只有一个最小值，然后找不到中间值，那么这个数组必然不包含递增的三个数（因为连递增的两个数都找不到）。
     *
     * 然后假设我们找到了两个递增的值，那么如果下一个值小于最小值，我们就应该将最小值的指针定位到这个值上。我们尽可能的使用最小值，防止后面出现了更小的一对递增值，而即使不出现，也不妨碍我们找到解（因为最终是看能否找到大于中间值的值）。
     * 如果下一个值大于最小值，且小于中间值，则我们使用该值作为中间值(因为如果最小的中间值都得不到解，那么就是false，这样也保证了覆盖所有的情况)。
     *
     * 最后，如果找到了大于中间值的值，则为true.
     *
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        //假设已经找到了两个递增的值
        for (int i = 0; i < nums.length; i++) {
            //如果有更小的，操作一波
            if(nums[i] < small) {
                small = nums[i];
            //找到了比最小值小,比中间值大，就更新中间值
            }else if(nums[i] > small && nums[i] <= big) {
                big = nums[i];
            //只要找到比中间值大的，就返回true
            }else if(nums[i] > big) {
                return true;
            }
        }
        return false;
    }
}
