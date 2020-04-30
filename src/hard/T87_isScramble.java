package hard;

/**
 * @author 李聪
 * @date 2020/2/13 17:42
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *  great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 *
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat"
 *
 */
public class T87_isScramble {
    public static void main(String[] args) {

    }
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }
        //判断两个字符串每个字母出现的次数是否一致
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a'] ++;
            letters[s2.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0)
                return false;
        }
        //遍历每个位置
        for (int i = 1; i < s1.length(); i++) {
            //情况1
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))) {
                return true;
            }
            //情况2
            if(isScramble(s1.substring(i),s2.substring(0,s2.length() - i)) &&
                isScramble(s1.substring(0,i),s2.substring(s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
