package Test.April;

/*
 * 求最大公约数
 * 辗转相除法：取两个数中最大的数做除数，较小的数做被除数，用最大的数除较小数，
 * 如果余数为0，则较小数为这两个数的最大公约数，如果余数不为0，用较小数除上一步计算出的余数，
 * 直到余数为0，则这两个数的最大公约数为上一步的余数。
 */
public class OjiLIDe {
    private OjiLIDe() {}
    public String add(String str) {
        return "";
    }
    public String add() {
        return "";
    }
    public static void main(String[] args) {

        OjiLIDe m = new OjiLIDe();

        System.out.println(gcd(3412421,12314));
    }

    public static long gcd(long m,long n) {
        while(n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
            System.out.println("m: "+m+"  n: "+n);
        }
        return m;
    }
}
