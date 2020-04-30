package hard;

/** leetCode 10 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 *     s 可能为空，且只包含从 a-z 的小写字母。
 *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class T10_isMatch_10_4 {
    public static void main(String[] args) {
        T10_isMatch_10_4 test = new T10_isMatch_10_4();
        boolean aaab = test.isMatch("", ".*");
        System.out.println(aaab);


    }

    /**
     *
     * @param s     字符串
     * @param p    字符规律
     * @return
     */
    public boolean isMatch(String s, String p) {

        //使用动态规划 dp[i][j]表示s的前i个字符和p的前j个字符的匹配情况
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        //注意：dp下标与s,p对应元素的下表相差1，也就是说，dp[i][j]表示当前应该匹配s[i-1]与p[j-1]
        for(int j = 2; j <= lp; j++)
            //即s1的前0个字符和s2的前i个字符能否匹配--可以去掉之后的  因为 '*' 表示零个或多个，这里 'c' 为 0 个
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for(int i = 1; i <= ls; i++) {
            for(int j = 1; j <= lp; j++) {
                int m = i - 1, n = j - 1;
                if(p.charAt(n) == '*')
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] &&
                            (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');
                //直接匹配
                else if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[ls][lp];

     /*  if(s==null || p==null)
           return false;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        return dp(sc,pc,0,0);*/
    }

    private boolean dp(char[] s, char[] p, int i, int j) {
        int n = s.length;
        int m = p.length;
        //规律跑到最后了
        if(j >= m)
            return i == n;
        //判断第一个字符匹配结果
        boolean j_match = (i < n && (s[i] == p[j] || p[j] == '.'));
        if(j+1 < m && p[j + 1] == '*')
            return dp(s,p,i,j + 2) || (j_match && dp(s,p,i+1,j));
        return j_match && dp(s,p,i+1,j+1);
    }





}
