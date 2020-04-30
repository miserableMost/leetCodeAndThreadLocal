package Test.August;

/**
 * leetCode 191 :位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class D5_hammingWeight_191 {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //逐位的检查是否为1
            if((n & mask) != 0){
                count ++;
            }
            mask <<= 1;
        }
        return count;

    }
}
