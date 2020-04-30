package medium2;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class T211_WordDictionary_9_23 {
    public static void main(String[] args) {

    }

}
class WordDictionary {
   static final class TrieNode {
       private final TrieNode[] children;
       private boolean isEnd;
       public TrieNode() {
           children = new TrieNode[26];
       }
   }
    private TrieNode root;
    public WordDictionary() {
       root = new TrieNode();
    }

    public void addWord(String word) {
       TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           int j = word.charAt(i) - 'a';
           //如果字符不存在
           if(node.children[i] == null) {
               node.children[j] = new TrieNode();
           }
           node = node.children[j];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        return contains(root,word,0);
    }

    private boolean contains(TrieNode node, String word, int i) {
        for(;node != null && i < word.length(); i ++) {
            char c = word.charAt(i);
            if(c == '.') {
                //在下一层寻找
                for (int j = 0; j < 26; j++) {
                    if(contains(node.children[j],word,i + 1))
                        return true;
                }
                return false;
            }
            //如果不为.到特定的子树找
            node = node.children[c - 'a'];
        }
        return node != null && node.isEnd;

    }
}