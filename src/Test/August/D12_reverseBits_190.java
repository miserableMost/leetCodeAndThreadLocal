package Test.August;

/**
 * leetCode 190 : 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class D12_reverseBits_190 {
    public static void main(String[] args) {
          int n = -3;
          reverseBits(n);

    }
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> i; //向右移动
            temp = temp & 1;     //取最低位
            temp = temp << (31 - i);   //低位换到高位去
            res |= temp;
        }
        return res;
    }
}
