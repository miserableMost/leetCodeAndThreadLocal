package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetCode 131 : 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class T131_partition_9_10 {
    public static void main(String[] args) {

    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0)
            return res;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //len表示长度--dp数组表示是否是回文串
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        dfs(s,0,dp,res,new Stack<>());
        return res;
    }

    private void dfs(String s, int start, boolean[][] dp, List<List<String>> res, Stack<String> temp) {
        if(start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(!dp[start][i]) {
                continue;
            }
            temp.add(s.substring(start,i + 1));
            dfs(s,i + 1,dp,res,temp);
            temp.pop();
        }
    }

   /* private List<List<String>> dfs(String s, int start, boolean[][] dp) {
        //递归出口，空字符串
        if(start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            //当前切割后是回文串才考虑
            if(dp[start][i]) {
                String left = s.substring(start,i + 1);
                //遍历后边字符串的所有结果，将当前的字符串加到头部
                for (List<String> l : dfs(s, i + 1, dp)) {
                    l.add(0,left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }*/
}
