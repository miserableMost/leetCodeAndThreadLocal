package Test.August;

/**
 * leetCode 557 : 反转字符串中的单词
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 */
public class D6_reverseWords_557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] sp = s.split(" ");
        for (int i = 0; i < sp.length; i++) {
            StringBuilder sb = new StringBuilder(sp[i]);
            sp[i] = sb.reverse().toString();
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sp.length - 1; i++) {
            res.append(sp[i] + " ");
        }
        res.append(sp[sp.length - 1]);
       return res.toString();
    }

}
