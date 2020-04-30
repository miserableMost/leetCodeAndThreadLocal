package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 18:24
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class T8 {
    public static void main(String[] args) {

    }
    public int NumberOf1(int n) {
        int res = 0;
        int mask = 1;
        while(n != 0) {
            if((n & mask) == 1) {
                res ++;
            }
            //将n移动
            n = n >>> 1;
        }
        return res;
    }
}
