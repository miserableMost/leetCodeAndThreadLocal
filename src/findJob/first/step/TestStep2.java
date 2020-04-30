package findJob.first.step;

/**
 * @author 李聪
 * @date 2019/12/1 21:38
 */
public class TestStep2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        loop(4);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static int loop(int n) {
        if(n < 1)
            throw new IllegalArgumentException(n + "不能小于1");
        if(n == 1 || n == 2)
            return n;
        int one = 2;  //初始化第一级台阶的走法
        int two = 1;  //初始化走到第一级台阶的走法
        int sum = 0;

        for (int i = 3; i <= n ; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

}
