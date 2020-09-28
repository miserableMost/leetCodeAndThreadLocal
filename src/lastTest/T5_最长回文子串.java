package lastTest;

/**
 * @author 李聪
 * @date 2020/9/9 17:08
 */
public class T5_最长回文子串 {
    private int l = 0,r = -1;
    private int ans = 0;

    public static void main(String[] args) {
        T5_最长回文子串 t = new T5_最长回文子串();
        t.longestPalindrome("babad");
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        for(int i = 0;i < s.length(); i++) {
            count(s,i,i);
            count(s,i,i + 1);
        }
        return s.substring(l,r + 1);
    }
    public void count(String s,int start,int end){
        int left = start,right = end;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        if(right - left - 1 > ans){
            r = right - 1;
            l = left + 1;
            ans = right - left - 1;
        }
    }
}
