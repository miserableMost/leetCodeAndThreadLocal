package hard;

/**
 * @author 李聪
 * @date 2020/2/12 14:57
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class T45_jump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4,2,1};
        int jump = jump(nums);
        System.out.println(jump);
    }
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //这里有个小细节，因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if(i == end) {       //遇到边界，就更新边界，并且步数+1
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }

}
