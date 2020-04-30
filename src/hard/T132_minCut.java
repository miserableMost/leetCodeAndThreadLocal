package hard;

/**
 * @author 李聪
 * @date 2020/2/14 11:48
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 */
public class T132_minCut {
    public static void main(String[] args) {

    }
    public int minCut(String s) {
        int len = s.length();
        if(len < 2)
            return 0;
        int[] dp = new int[len];
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < len; i++) {
            if(checkPalindrom(s,0,i)) {
                dp[i] = 0;         //已经是回文串
                continue;
            }
            //当j == i成立的时候,s[i]就一个字符，一定是回文
            for (int j = 0; j < i; j++) {
                if(checkPalindrom(s,j + 1,i)) {
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[len - 1];

    }
    private boolean checkPalindrom(String s,int left,int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
