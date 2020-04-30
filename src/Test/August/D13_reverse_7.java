package Test.August;

/**
 * leetCode 7 : 整数反转
 *
 */
public class D13_reverse_7 {
    public static void main(String[] args) {
        int reverse = reverse(-1342);
        System.out.println(reverse);
    }
    //反转整数的方法可以与反转字符串进行类比。
    //
    //我们想重复“弹出” xxx 的最后一位数字，并将它“推入”到 rev\text{rev}rev 的后面。最后，rev\text{rev}rev 将与 xxx 相反。
    //
    //要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法
    //
    public static int reverse(int x){
        int res = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            res = res * 10 + pop;

        }
        return res;
    }
}
