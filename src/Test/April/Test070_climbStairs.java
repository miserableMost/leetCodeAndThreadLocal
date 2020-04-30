package Test.April;

/**leetCode 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Test070_climbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(9));
    }



/*
有n阶楼梯，每次只能走1～m步，不能后退，问有几种走法？
可以推测:
F(n) = F(n-1) + F(n-2) + ... + F(n-m)
n个台阶，一开始可以爬 1 步，也可以爬 2 步，那么n个台阶爬楼的爬楼方法就等于
一开始爬1步的方法数 + 一开始爬2步的方法数，这样我们就只需要计算n-1个台阶的方法数和n-2个台阶方法数，
同理，计算n-1个台阶的方法数只需要计算一下n-2个台阶和n-3个台阶，
计算n-2个台阶需要计算一下n-3个台阶和n-4个台阶……

 */
    //斐波那契数列，每次n+2的值等于n和n+1的值之和

    /**
     * 分析一下:1级台阶只有一种方法 一次跨1级，2级台阶有2种方法，可以一次跨2阶，也可以分两次跨1阶，
     * 3级台阶1 1 1,1 2,2 1,3中方法........,
     * 4级台阶5种，5级8种，明显就是一个兔子繁殖的问题(又称斐波那契数列)
     */
    public static int climbStairs(int n) {
        if (n <= 0)
            return 0;
        //台阶数  1  2  3  4  5  6  7  8  9
        //i       0  1  2  3  4  5  6  7  8
        //步数 1  1  2  3  5  8  13 21 34 55
        int pre = 0, cur = 1, next = 0;
        for (int i = 0; i < n; i++) {
            //pre,cur,next向后移动
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }

}
