package hard;

/** leetCode 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 */
public class T32_longestValidParentheses_10_6 {
    public static void main(String[] args) {

    }

    /**
     * 这个问题可以通过动态规划解决。我们定义一个 dp\text{dp}dp 数组，其中第 iii 个元素表示以下标为 iii 的字符结尾的最长有效子字符串的长度。
     * 我们将 dp\text{dp}dp 数组全部初始化为 0 。现在，很明显有效的子字符串一定以 ‘)’\text{‘)’}‘)’ 结尾。这进一步可以得出结论：
     * 以 ‘(’\text{‘(’}‘(’ 结尾的子字符串对应的 dp\text{dp}dp 数组位置上的值必定为 0 。所以说我们只需要更新 ‘)’\text{‘)’}‘)’ 在 dp\text{dp}dp 数组中对应位置的值。
     *
     * 为了求出 dp\text{dp}dp 数组，我们每两个字符检查一次，如果满足如下条件
     *
     *     s[i]=‘)’\text{s}[i] = \text{‘)’}s[i]=‘)’ 且 s[i−1]=‘(’\text{s}[i - 1] = \text{‘(’}s[i−1]=‘(’ ，也就是字符串形如‘
     *     ‘……()"``……()"‘‘……()"，我们可以推出：
     *
     *     dp[i]=dp[i−2]+2\text{dp}[i]=\text{dp}[i-2]+2 dp[i]=dp[i−2]+2
     *
     *     我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。
     *
     *     s[i]=‘)’\text{s}[i] = \text{‘)’}s[i]=‘)’ 且 s[i−1]=‘)’\text{s}[i - 1] = \text{‘)’}s[i−1]=‘)’，
     *     也就是字符串形如 ‘‘.......))"``.......))"‘‘.......))" ，我们可以推出：
     *     如果 s[i−dp[i−1]−1]=‘(’\text{s}[i - \text{dp}[i - 1] - 1] = \text{‘(’}s[i−dp[i−1]−1]=‘(’ ，那么
     *
     *     dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2\text{dp}[i]=\text{dp}[i-1]+\text{dp}[i-\text{dp}[i-1]-2]+2 dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     *     这背后的原因是如果倒数第二个 ‘)’\text{‘)’}‘)’ 是一个有效子字符串的一部分（记为 subssub_ssubs​），对于最后一个 ‘)’\text{‘)’}‘)’ ，
     *     如果它是一个更长子字符串的一部分，那么它一定有一个对应的 ‘(’\text{‘(’}‘(’ ，它的位置在倒数第二个 ‘)’\text{‘)’}‘)’
     *     所在的有效子字符串的前面（也就是 subssub_ssubs​ 的前面）。因此，如果子字符串 subssub_ssubs​ 的前面恰好是 ‘(’\text{‘(’}‘(’ ，
     *     那么我们就用 222 加上 subssub_ssubs​ 的长度（dp[i−1]\text{dp}[i-1]dp[i−1]）去更新 dp[i]\text{dp}[i]dp[i]。除此以外，我们也会把有效子字符串
     *     ‘‘(,subs,)"``(,sub_s,)"‘‘(,subs​,)"之前的有效子字符串的长度也加上，也就是加上 dp[i−dp[i−1]−2]\text{dp}[i-\text{dp}[i-1]-2]dp[i−dp[i−1]−2] 。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxas = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {         //保持不越界
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxas = Math.max(dp[i],maxas);

            }
        }
        return maxas;
    }
}
