package findJob.first.step;

/**
 * @author 李聪
 * @date 2019/12/1 21:31
 */
public class TestStep {

    public void test() {
        long start = System.currentTimeMillis();
        f(4);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    public int f(int n) {
        if(n < 1)
            throw new IllegalArgumentException(n + "不能小于1");
        if(n == 1 || n == 2)
            return n;
        return f(n - 1) + f(n - 2);
    }
}
