package Test.August;

/**
 * leetCode 231:2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
 */
public class D11_isPowerOfTwo_231 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo(int n) {
         //利用换底公式
        double m = Math.log10(n) / Math.log10(2);
        return (m - (int) m) == 0 ? true : false;
    }
}
