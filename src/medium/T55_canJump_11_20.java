package medium;

/**
 * leetCode 55 : 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 */
public class T55_canJump_11_20 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        T55_canJump_11_20 test = new T55_canJump_11_20();
        boolean b = test.canJump(nums);
        System.out.println(b);
    }
    //顺着推--速度慢
    /*public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }*/
    //逆着推
    public boolean canJump(int[] nums) {
        if(nums == null)
            return false;
        //需要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= pos)
                pos = i;
        }
        //pos是否在最初
        return pos == 0;
    }
}
