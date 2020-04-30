package medium;

/**
 * leetCode 91 : 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数
 *给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class T91_numDecodings_9_5 {
    public static void main(String[] args) {

    }
    //其实dp[i]只和dp[i+1]以及dp[i+2]相关。---动态规划
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        int before = 1;
        int len = s.length();
        if(s.charAt(len - 1) != '0') {
            res = 1;
        }
        //从后往前
        //如果s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26 ,则dp[i] = dp[i + 1] + dp[i + 2],
        //否则dp[i] = dp[i + 1]
        for (int i = len - 2; i >= 0 ; i--) {
            if(s.charAt(i) == '0'){
                before = res;
                res = 0;
                continue;
            }
            if((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res += before;
                before = res - before;
            }else {
                before = res;
            }
        }
        return res;
    }
}
