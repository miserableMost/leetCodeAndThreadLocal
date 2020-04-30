package Test.April;

/** leetCode461: 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *示例:
 *输入: x = 1, y = 4
 *输出: 2
 *解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 */
public class Test461_hammingDistance_REMEMBER {
    public static void main(String[] args) {
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

    public static int hammingDistance(int x, int y) {
       /*  我的做法
        String strX = Integer.toBinaryString(x);
        String strY = Integer.toBinaryString(y);
        String transferX = transfer(strX);
        System.out.println(transferX);
        String transferY = transfer(strY);
        System.out.println(transferY);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if(transferX.charAt(i) != transferY.charAt(i))
                count ++ ;
        }
        return count;
    }
    //将其转化为32位数字
    public static String transfer(String str){
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        if(length < 32){
            int add = 32 - length;
            for (int i = 0; i < add; i++) {
                sb.append('0');
            }
        }
        return sb.append(str).toString();
       */
       int count = 0;
       //将两个数按位异或，计算其中1的个数
       int res = x^y;
       //只要不为0就来操作
        while(res != 0) {
            /**
             *  重点： num & (num - 1)可以快速地移除最右边的bit 1
             */
            res &= res -1;
            //消除一个记录一个
            count ++;
        }
        return count;
    }
}
