package Test.July;

/**
 * leetCode 1071 :字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2

 */
public class Test1071_gcdOfStrings_30_REMEMBER_GCD {
    public static void main(String[] args) {
        String str1 = "ABABABAB";
        String str2 = "ABAB";
        System.out.println(gcdOfStrings(str1,str2));
    }
    public static String gcdOfStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        //如果不满足这个条件，必然不可能有最大公因子
        if(!(str1 + str2).equals(str2 + str1))
            return "";
        int len = gcd(length1,length2);
        return str1.substring(0, len);
    }
    //欧几里得算法 公式gcd(a,b) = gcd(b,a mod b)。
    public static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}
