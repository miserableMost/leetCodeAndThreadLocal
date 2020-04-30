package medium2;

/**
 * @author 李聪
 * @date 2020/4/29 18:55
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 *     给定 0 和 1 的数量都不会超过 100。
 *     给定字符串数组的长度不会超过 600。
 *
 */
public class T474_一和零 {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = countZeroAndOne(str);
            for (int zero = m; zero >= count[0]; zero--) {
                for (int one = n; one >= count[1]; one--) {
                    dp[zero][one] = Math.max(1 + dp[zero - count[0]][one - count[1]],dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] c = new int[2];
        for (int i = 0; i < str.length(); i++) {
            c[str.charAt(i) - '0'] ++;
        }
        return c;
    }

}
