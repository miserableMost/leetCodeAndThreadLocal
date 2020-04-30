package Test.August;

/**
 * leetCode 917 : 仅仅反转字母
 */
public class D13_reverseOnlyLetters_917 {
    public static void main(String[] args) {
         String s = "a-bC-dEf-ghIj";
        String s1 = reverseOnlyLetters(s);
        System.out.println(s1);
    }
    public static String reverseOnlyLetters(String S) {
       if(S == null || S.length() <= 1)
           return S;
       int l = 0;
       int r = S.length() - 1;
        char[] sc = S.toCharArray();   //转成字符数组
        while(l < r){
           //从左往右操作
           char lc = sc[l];
            if (lc < 'A' || (lc > 'Z' && lc < 'a') || lc > 'z') {
                //遇到非字母,往右移动一位
                l ++;
                continue;
            }
            char rc = sc[r];
            //从右往左遇到非字母
            if (rc < 'A' || (rc > 'Z' && rc < 'a') || rc > 'z') {
                r --;
                continue;
            }
            //只有左右都为字符时
            sc[l ++] = rc;
            sc[r --] = lc;
       }
        return new String(sc);
    }
}
