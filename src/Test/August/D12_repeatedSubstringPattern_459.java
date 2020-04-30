package Test.August;

/**
 * leetCode 459:重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class D12_repeatedSubstringPattern_459 {
    public static void main(String[] args) {
        String regex = "\\d+";
        String ss = "*";
        String text = "hello21234http313java";
        String s = text.replaceAll(regex, ss);
        System.out.println(s);
    }
    public boolean repeatedSubstringPattern(String s) {
        return s.matches("(\\w+)\\1+");
    }
}
