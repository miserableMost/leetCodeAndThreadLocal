package medium;

import java.util.LinkedList;

/**
 * leetCode 151 : 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class T151_reverseWords_9_11 {
    public static void main(String[] args) {
        String the_sky_is_blue = reverseWords("  hello world!  ");
        System.out.println(the_sky_is_blue);
    }
    public static String reverseWords(String s) {
        if(s.equals(" ") || s.trim().equals(""))
            return "";
        String[] s1 = s.split(" ");
        /*for (String str : s1) {
            System.out.print(str + " ");
        }*/
        //可以使用栈
        LinkedList<String> list = new LinkedList<>();
        for (String str : s1) {
            if(str.equals("")  || str == null)
                continue;
            list.addFirst(str);
        }
        StringBuffer sb = new StringBuffer();
        for (String s2 : list) {
            sb.append(s2 + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
