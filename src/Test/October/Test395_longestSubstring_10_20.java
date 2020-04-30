package Test.October;

/**
 * leetCode 395:至少有k个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class Test395_longestSubstring_10_20 {
    public static void main(String[] args) {

    }
    //解题思路：递归拆分子串，分治。先统计出每个字符出现的频次，维护一对双指针
    // 从首尾开始统计，从首尾往中间排除，如果出现次数小于k则不可能出现在最终子串中，
    // 排除并挪动指针，然后得到临时子串，依次从头遍历，一旦发现出现频次小于k的字符，
    // 以该字符为分割线，分别递归求其最大值返回。
    //

    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length())
            return 0;
        return longest(s.toCharArray(),0,s.length() - 1,k);
    }
    //用i,j指向子串
    private int longest(char[] s, int p1, int p2, int k) {
        if(p2 - p1 + 1 < k)
            return 0;
        //统计这个子串
        int[] times = new int[26];
        for (int i = p1;i <= p2;i++) {
            times[s[i] - 'a'] ++;
        }
        //两边不满足减一波
        while(p2 - p1 + 1 >= k && times[s[p1] - 'a'] < k) {
            p1 ++;
        }
        while(p2 - p1 + 1 >= k && times[s[p2] - 'a'] < k) {
            p2 --;
        }
        //重新检查一下
        if(p2 - p1 + 1 < k)
            return 0;
        for (int i = p1; i <= p2; i++) {
            if(times[s[i] - 'a'] < k) {
                return Math.max(longest(s,p1,i - 1,k) ,longest(s,i + 1,p2,k));
            }
        }
        return p2 - p1 + 1;


    }


}
