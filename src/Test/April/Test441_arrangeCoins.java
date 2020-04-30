package Test.April;

/**
 * leetCode :441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 */
public class Test441_arrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {
        //解方程法————注意防止溢出
        return (int) (Math.sqrt(2*(long)n+0.25)-0.5);
    }

    /**
     * 迭代求解法 O(n)
     *
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 二分查找，O(log(n / 2 + 1))
     *
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
}
