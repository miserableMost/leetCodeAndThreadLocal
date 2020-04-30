package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 728:自然数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 */
public class D14_selfDividingNumbers_728 {
    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(1, 22);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean add = true;
            int temp = i;
            //逐步取下每一位，注意如果此位为0则不可除
            while(temp != 0){
                int yu = temp % 10;
                if(yu == 0 || i % yu != 0){
                    add = false;
                    break;
                }
                temp = temp / 10;
            }
            if(add)
                res.add(i);
        }
        return res;
    }
}
