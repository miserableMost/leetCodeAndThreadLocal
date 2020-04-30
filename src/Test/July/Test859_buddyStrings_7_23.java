package Test.July;

/**
 * leetCode 859:亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回 true ；否则返回 false
 */
public class Test859_buddyStrings_7_23 {

    public static void main(String[] args) {
         String a = "ab";
         String b = "ab";
        boolean b1 = buddyStrings(a, b);
        System.out.println(b1);
    }
    public static boolean buddyStrings(String A, String B) {
          //长度不相等返回false
        if(A.length() != B.length())
            return false;
        //a,b若相等，则看a中是否有两个及以上相同的字符，可以相互调换
        if(A.equals(B)){
            int[] temp = new int[26];
            for (int i = 0; i < A.length(); i++) {
                //将A中的字符记录到数组中
                temp[A.charAt(i) - 'a'] ++;
            }
            for (int i : temp) {
                //有两个及以上相同字符，返回true
                if(i > 1){
                    return true;
                }
            }
            return false;
        //A、B不相同时，只能有且必须两个字符不相同才能true
        }else{
            //初始化这两个字符的位置
            int first = -1,second = -1;
            for (int i = 0; i < A.length(); i++) {
                if(A.charAt(i) != B.charAt(i)){
                    if(first == -1){
                        first = i;
                    }else if(second == -1){
                        second = i;
                    }else{
                        //出现第三个字符不同，返回false
                        return false;
                    }
                }
            }
            //需要检查是否有两个字符不同
            return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }

    }
}
