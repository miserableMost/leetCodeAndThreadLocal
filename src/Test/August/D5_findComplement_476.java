package Test.August;

/**
 * leetCode 476 :数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 *
 *     给定的整数保证在32位带符号整数的范围内。
 *     你可以假定二进制数不包含前导零位。
 */
public class D5_findComplement_476 {
    public static void main(String[] args) {
        findComplement(100);
    }
    //这个函数的作用是取 i 这个数的二进制形式最左边的最高一位且高位后面全部补零，最后返回int型的结果。
    public static int findComplement(int num) {
        return (Integer.highestOneBit(num) << 1) - num - 1;
    }
}
