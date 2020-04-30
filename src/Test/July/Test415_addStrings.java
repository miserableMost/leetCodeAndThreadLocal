package Test.July;

/**
 * leetCode415: 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *     num1 和num2 的长度都小于 5100.
 *     num1 和num2 都只包含数字 0-9.
 *     num1 和num2 都不包含任何前导零

 */
public class Test415_addStrings {
    public static void main(String[] args) {
        String a = "99";
        String b = "99";
        System.out.println(addStrings(a,b));
    }



    public static String addStrings(String num1, String num2) {
        //定义一个字符串缓冲区用于拼接
        StringBuilder sb = new StringBuilder();
        //定义一个进位
        int carry = 0;
        int NL1 = num1.length();
        int NL2 = num2.length();
        for (int i = NL1 - 1,j=NL2 - 1; i >= 0 || j >= 0 ; i--,j--) {
            int num = carry;
            //需要将短的高位补0，进行逐位相加
            num += i >= 0 ? num1.charAt(i) - '0' : 0;
            num += j >= 0 ? num2.charAt(j) - '0' : 0;
            //求此位和
            sb.append(num % 10);
            //求进位
            carry = num / 10;
        }
        //检查是否最后需要补位
        sb.append(carry > 0 ? carry : "");
        return sb.reverse().toString();
    }
}
