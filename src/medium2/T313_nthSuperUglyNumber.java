package medium2;

/**
 * @author 李聪
 * @date 2019/12/11 20:46
 * leetCode313 超级丑数
 *  编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 */

public class T313_nthSuperUglyNumber {
    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        int n = 12;
        T313_nthSuperUglyNumber test = new T313_nthSuperUglyNumber();
        int i = test.nthSuperUglyNumber(n, primes);
        System.out.println(i);
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        //定义一个数组
        int[] dp = new int[n];
        dp[0] = 1;
        //idx对应的是primes中每个数应该乘以的丑数位置
        int[] idx = new int[primes.length];
        int i = 1;
        while(i < n) {
            int minVal = Integer.MAX_VALUE;
            //求出最小的
            for (int j = 0; j < primes.length; j++) {
                //上一个丑数乘以primes各数求最小的
                //新丑数乘以primes中最小的再跟上一波的数比较
                int tmp = dp[idx[j]] * primes[j];
                if(tmp < minVal) {
                    minVal = tmp;
                }
            }
            //更新index。让已经等于的向右移，记录这个丑数的位置
            for (int j = 0; j < primes.length; j++) {
                if(minVal == primes[j] * dp[idx[j]]) {
                    idx[j] ++;
                }
            }
            dp[i] = minVal;
            i ++;
        }
        return dp[n - 1];
    }
}
