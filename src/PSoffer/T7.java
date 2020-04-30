package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/19 16:08
 * 斐波那契数列
 */
public class T7 {
    public int Fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
