package medium;

/**
 * leetCode 8 : 字符串转换整数
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
public class T8_myAtoi_10_28 {
    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        //去掉空
        str = str.trim();
        if(str.equals("") || str.length() == 0) {
            return 0;
        }
        //判断正负数
        int sign = 1;
        long res = 0;
        int start = 0; //记录数字的开始
        //获取首字符,判断正负数
        char c = str.charAt(0);
        if(c == '+') {
            sign = 1;
            start ++;
        }else if(c == '-') {
            sign = -1;
            start ++;      //首位置后移
        }
        for (int i = start; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                //如果已经不是数字
                return (int) (res * sign);
            }
            res = res * 10 + str.charAt(i) - '0';
            //越界处理
            if(sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            //res只记录绝对值
            if(sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (res * sign);

    }
}
