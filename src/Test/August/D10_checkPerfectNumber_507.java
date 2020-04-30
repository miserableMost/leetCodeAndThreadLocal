package Test.August;

/**
 * leetCode 507:完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 */
public class D10_checkPerfectNumber_507 {
    public static void main(String[] args) {
        boolean b = checkPerfectNumber(28);
        System.out.println(b);
    }
    public static boolean checkPerfectNumber(int num) {
        int res = 1;
        if(num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                res += i;
                res += num / i;
            }
        }
        return res == num;
    }
}
