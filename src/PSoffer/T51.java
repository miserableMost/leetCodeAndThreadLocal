package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 11:13
 */
public class T51 {
    public static void main(String[] args) {
        char[] str = {};
        char[] pattern = {'.','*'};
        T51 t51 = new T51();
        boolean match = t51.match(str, pattern);
        System.out.println(match);
    }
    public boolean match(char[] str, char[] pattern) {
        if(str == null && pattern == null)
            return true;
        int sl = str.length;
        int pl = pattern.length;
        if(sl == 0 && pl == 0)
            return true;
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        //初始状态
        dp[0][0] = true;
        for (int j = 2; j <= pl; j++) {
            dp[0][j] = dp[0][j - 2] && pattern[j - 1] == '*';
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                int m = i - 1,n = j - 1;
                if(pattern[n] == '*') {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (str[m] == pattern[n - 1] || pattern[n - 1] == '.');
                }else if(str[m] == pattern[n] || pattern[n] == '.') {
                    dp[i][j] = dp [i - 1][j - 1];
                }
            }
        }
        return dp[sl][pl];
    }
}
