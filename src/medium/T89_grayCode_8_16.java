package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 89 : 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 */
public class T89_grayCode_8_16 {
    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    //关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
    public static List<Integer> grayCode(int n) {

       List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i << 1);
        }
       return res;
    }
}
