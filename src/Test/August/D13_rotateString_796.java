package Test.August;

/**
 * leetCode 796 : 旋转字符串
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True
 *
 */
public class D13_rotateString_796 {
    public static void main(String[] args) {
         String a = "abcde";
         String b = "abced";
        boolean b1 = rotateString(a, b);
        System.out.println(b1);
    }

    public static boolean rotateString(String A, String B) {
        /*if ((A == null && B == null) || (A.length() == 0 && B.length() == 0))
            return true;
        if (A.length() != B.length())
            return false;
        //计算移动次数
        int count = 0;
        while(count < A.length()){
             //新生成的字符串
             String s = A.substring(1,A.length()) + A.charAt(0);
             //判断是否相等
             if(s.equals(B)){
                 return true;
             }
             //A更新
             A = s;
             count ++;
        }
        return false;*/
        //思路：首先确认两个字符串的长度要相等。其次只要保证A+A 的字符串中包含B就可以了。因为A+A已经包含了所有可移动的方案。
        return A.length() == B.length() && (A+A).contains(B);
    }
}
