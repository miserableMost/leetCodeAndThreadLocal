package medium;

/**
 * leetCode 5 ：最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class T5_longestPalindrome_8_27 {
    public static void main(String[] args) {
        T5_longestPalindrome_8_27 test = new T5_longestPalindrome_8_27();
        test.longestPalindrome("ababaaabc");
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1)
            return "";
        int start = 0,end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = isPalindrom(s,i,i);
            int len2 = isPalindrom(s,i,i + 1);
            int len = Math.max(len1,len2);
            if(len > end - start + 1){
                //是奇数的话前后加减必须相同-偶数前面减的肯定少一些
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    public int isPalindrom(String s,int left,int right) {
        int L = left,R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L --;
            R ++;
        }
        //R - 1 - (L + 1) + 1
        return R - L - 1;
    }
}
