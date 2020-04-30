package Test.August;

/**
 * leetCode 1137: 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2_REMEMBER = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class D5_tribonacci_1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
    public static int tribonacci(int n) {
         int first = 0,second = 1,third = 1;
         if(n == 0)
             return first;
         if(n == 1)
             return second;
         if(n == 2)
             return first + second;
         int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second + third;
            first = second;
            second = third;
            third = sum;
        }
        return sum;
    }
}
