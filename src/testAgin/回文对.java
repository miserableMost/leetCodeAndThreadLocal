package testAgin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/6/25 21:41
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，
 * 使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串
 */
public class 回文对 {
    public static void main(String[] args) {

    }
    private TrieNode root;


    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        this.root = new TrieNode();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            TrieNode cur = root;
            if(isPalindrome(rev.substring(0)))
                cur.suffix.add(i);
            for (int j = 0; j < rev.length(); j++) {
                char ch = rev.charAt(j);
                if(cur.next[ch - 'a'] == null)
                    cur.next[ch - 'a'] = new TrieNode();
                cur = cur.next[ch - 'a'];
                if(isPalindrome(rev.substring(j + 1)))
                    cur.suffix.add(i);
            }
            //维护以该节点为终止节点的单词
            cur.words.add(i);
        }
        for (int i = 0; i < n; i++) {
            String word = words[i];
            TrieNode cur = root;
            int j = 0;
            while(j < word.length()) {
                // // 到j位置，后续字符串若是回文对，则在该节点位置上所有单词都可以与words[i]构成回文对
                //                // 因为我们插入的时候是用每个单词的逆序插入的:)
                if(isPalindrome(word.substring(j))) {
                    for (Integer k : cur.words) {
                        if(k != i)
                            ans.add(Arrays.asList(i,k));
                    }
                }
                char ch = word.charAt(j);
                if(cur.next[ch - 'a'] == null)
                    break;
                cur = cur.next[ch - 'a'];
                j ++;
            }
            // words[i]遍历完了，现在找所有大于words[i]长度且符合要求的单词，suffixs列表就派上用场了:)
            if(j == word.length()) {
                for (Integer k : cur.suffix) {
                    if(k != i)
                        ans.add(Arrays.asList(i,k));
                }
            }
        }
        return ans;
    }


    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l ++;
            r --;
        }
        return true;
    }
}
class TrieNode {
    TrieNode[] next;
    List<Integer> words;
    List<Integer> suffix;

    public TrieNode() {
        next = new TrieNode[26];
        words = new ArrayList<>();
        suffix = new ArrayList<>();
    }

}
