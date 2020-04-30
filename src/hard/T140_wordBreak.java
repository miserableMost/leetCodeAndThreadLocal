package hard;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/2/14 13:57
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 *     分隔时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 */
public class T140_wordBreak {
    public static void main(String[] args) {

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //状态定义：以是s[i]为结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];
        //预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        for (int r = 0; r < len; r++) {
            if(wordSet.contains(s.substring(0,r + 1))) {
                dp[r] = true;
                continue;
            }
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if(dp[l] && wordDict.contains(s.substring(l + 1,r + 1))) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if(dp[len - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s,len - 1,wordSet,res,queue,dp);
            return res;
        }
        return res;
    }

    private void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (wordSet.contains(s.substring(0,end + 1))) {
            queue.addFirst(s.substring(0,end + 1));
            StringBuilder sb = new StringBuilder();
            for (String word : queue) {
                sb.append(word);
                sb.append(" ");
            }
            //去除最后的一个" "
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            queue.removeFirst();
        }
        for (int i = 0; i < end; i++) {
            if(dp[i]) {
                String suffix = s.substring(i + 1,end + 1);
                if(wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s,i,wordSet,res,queue,dp);
                    queue.removeFirst();
                }
            }
        }
    }
}
