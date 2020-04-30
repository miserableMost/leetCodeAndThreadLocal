package newTest.huisu;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字
 */
public class T357_countNumbersWithUniqueDigits_9_18 {
    public static void main(String[] args) {
        T357_countNumbersWithUniqueDigits_9_18 test = new T357_countNumbersWithUniqueDigits_9_18();
        int i = test.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }
    //动态规划
   /* 给定非负整数n, 寻找在区间[0, 10^n)之间所有不存在相同数字的数目，我们用dp[n]表示满足要求的数字总数
    dp[0] = 1，dp[1] = 10,
    dp[2] = 91, 很容易发现， 区间[0, 10^2)可以拆分为[0, 10^0）V [10^0, 10^1) V [10^1, 10^2）这三个区间的并集，
    而dp[0]表示 [0, 10^0）满足要求的数字个数
    dp[1]表示 [0, 10^0）V [10^0, 10^1) 满足要求的数字个数，容易联想到dp[1] = dp[0] + X， X表示在[10^0, 10^1)上满足要求的数字个数，
    dp[2]表示 [0, 10^0）V [10^0, 10^1) V [10^1, 10^2）满足要求数字个数， 同理， dp[2] = dp[1] + X, X表示在[10^1, 10^2)上满足要求的数字个数， 即不含重复数字的两位数，一共有9*10 = 90个
            推广开来
    n >= 1
    dp[n] = dp[n-1] + X
    X表示不含重复数字的n位数，对一个位数为n的数字，用0~9的数字去填充，一共有9*9*8.....*(9-(n-1))种不包含重复数字的可能,*/
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;   //初始情况
        int tar = 1;   //辅助计算
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 9 * tar;
            tar *= (10 - i);
        }
        if(n <= 10)
            return dp[n];
        else
            return dp[10];
    }
    /*public int countNumbersWithUniqueDigits(int n) {
        double count = Math.pow(10,n);
        int ans = 0;
        for (long i = 0; i < count; i++) {
            if(isValid(i)) {
                ans ++;
            }
        }
        return ans;
    }
    public boolean isValid(Long num) {
        Set<Integer> set = new HashSet<>();
        while(num > 0) {
            int yu = (int) (num % 10);
            if(set.contains(yu)) {
                return false;
            }
            set.add(yu);
            num = num / 10;
        }
        return true;
    }*/

}
