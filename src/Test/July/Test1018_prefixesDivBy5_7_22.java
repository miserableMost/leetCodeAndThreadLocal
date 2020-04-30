package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 1018:可被 5 整除的二进制前缀
 *
 */
public class Test1018_prefixesDivBy5_7_22 {
    public static void main(String[] args) {
        int[] a = {1,1,1,0,1};
        List<Boolean> booleans = prefixesDivBy5(a);
        for (Boolean b : booleans) {
            System.out.print(b+" ");
        }
    }
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int length = A.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            //将二进制转为十进制
            num = num * 2 + A[i];
            list.add(num % 5 == 0);
            //对5取模防止溢出
            num %= 5;
        }
        return list;
    }
}
