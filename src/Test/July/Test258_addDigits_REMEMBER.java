package Test.July;

/**
 * leetCode 258:各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class Test258_addDigits_REMEMBER {
    public static void main(String[] args) {
        System.out.println(addDigits2(199));
    }
    //效率太低
   /* public static int addDigits(int num) {
        String strNum = num + "";
        if(strNum.length() == 1){
            return Integer.parseInt(strNum);
        }
        int res =  0;
        for (int i = 0; i < strNum.length(); i++) {
            res += Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
        return addDigits(res);
    }*/
    //假设一个三位数整数n=100*a+10*b+c,变化后addn=a+b+c；
    // 两者的差值n-addn=99a+9b，差值可以被9整除，说明每次缩小9的倍数
    //不用计算缩小了多少次，最终有效的=原数-9*N,相当于取模
    // 那么我们可以对res=num%9，若不为0则返回res，为0则返回9
    //

    public static int addDigits2(int num) {
        if(num > 9){
            num = num % 9;
            if(num == 0)
                return 9;
        }
        return num;
    }
}
