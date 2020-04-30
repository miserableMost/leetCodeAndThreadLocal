package Test.July;

/**
 * leetCode 509:  斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是
 */
public class Test509_fib_25 {

    public static void main(String[] args) {
        int fib = fib(6);

    }
    public static int fib(int N) {
       if(N < 2)
           return N;
       int pre = 0,cur = 1;
        for (int i = 0; i < N - 1; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;


    }
}
