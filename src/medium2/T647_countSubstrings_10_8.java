package medium2;

/**
 * leetCode 647: 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class T647_countSubstrings_10_8 {
    int num = 0;
    public static void main(String[] args) {

    }
    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            //回文串为奇数
            //以每个字符为中心计算
            count(s,i,i);
            count(s,i,i + 1);
        }
        return num;
    }

    private void count(String s ,int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num ++;
            start --;
            end ++;
        }
    }
}
