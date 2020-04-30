package Test.July;

/**
 * leetCode 198: 打家劫舍
 * 方法一：动态规划
 *
 * 算法
 *
 * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
 *
 *     f(k) = 从前 k 个房屋中能抢劫到的最大数额，AiA_iAi​ = 第 i 个房屋的钱数。
 *
 * 首先看 n = 1 的情况，显然 f(1) = A1A_1A1​。
 *
 * 再看 n = 2，f(2) = max(A1A_1A1​, A2A_2A2​)。
 *
 * 对于 n = 3，有两个选项:
 *
 *     抢第三个房子，将数额与第一个房子相加。
 *
 *     不抢第三个房子，保持现有最大数额。
 *
 * 显然，你想选择数额更大的选项。于是，可以总结出公式：
 *
 *     f(k) = max(f(k – 2) + AkA_kAk​, f(k – 1))
 *
 * 我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
 *
 * 答案为 f(n)。可以用一个数组来存储并计算结果。
 * 不过由于每一步你只需要前两个最大值，两个变量就足够用了。
 *

 */
public class Test198_rob_31_REMEMBER_DP {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num,curMax);
            //继续向后记录
            preMax = temp;
        }
        return curMax;
    }
}
