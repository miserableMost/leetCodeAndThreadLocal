package Test.August;

/**
 * leetCode 371 : 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class D15_getSum_371 {
    public static void main(String[] args) {
        getSum(2,2);
    }
    //在一次取进位后，如何知道加进位时是否有连续进位？
    // ;应用当前进位数与原数取&，故设置temp
    public static int getSum(int a, int b) {
        int up = 0;        //进位
        int result = 0;
        int temp;

        result = a ^ b;   //异或
        up     = a & b;    //与
        while(up != 0)
        {
            up = up<<1;    //左移
            temp = result;
            result ^= up;
            up &= temp;
        }

        return result;


    }
}
