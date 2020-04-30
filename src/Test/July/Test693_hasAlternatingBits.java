package Test.July;

/**
 * leetCode 693 :交替位二进制
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 */
public class Test693_hasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(10));
    }
    public static boolean hasAlternatingBits(int n) {
        String strN = Integer.toBinaryString(n);
        int length = strN.length();
        for (int i = 1; i < length; i++) {
            if(strN.charAt(i) == strN.charAt(i - 1))
                return false;
        }
        return true;
    }

}
