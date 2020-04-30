package PSoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2019/12/25 18:42
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class T31 {
    public static void main(String[] args) {
        int[] nums = {3,32,321};
        T31 t = new T31();
        String s = t.PrintMinNumber(nums);
        System.out.println(s);
    }
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        List<Integer> list = new ArrayList<>();
        for (Integer num : numbers) {
            list.add(num);
        }
        list.sort((a,b) -> (a + "" + b).compareTo(b + "" + a));
        StringBuffer sb = new StringBuffer();
        for (Integer n : list) {
            sb.append(n);
        }
        return sb.toString();
    }
}
