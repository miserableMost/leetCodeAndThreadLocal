package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode :696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 分析
 *
 * 可以发现如果是0011的话会包含2个，即0011 01 ；如果是000111的话包含3个，即000111 0011 01 ；01的话只有一个。
 *
 * 也就是说有多少个重复的01即有多少个情况，
 *
 * 拿实例1来说 00110011 ： 可以找出三组 0011   1100   00011，每组都有2个，也就是6个。
 *
 * 所以我们可以把字符串相邻的0,1个数统计出来 ，实例一可统计为： 2 2 2  ；相邻取比较小的那个值相加 为 2+2+2 = 6
 *
 * 再来一个例子 000110000111  ： 统计每块儿的个数： 3  2   4   3 ；相邻较小数字相加：2+2+3 = 7

 */
public class Test696_countBinarySubstrings_7_23_REMEMBER {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
    public static int countBinarySubstrings(String s) {
        int result = 0;
        //使用list存放连续的字符数量
        List<Integer> list = new ArrayList<>();
        int index = 0;   //index表示在第几个位置加
        char temp = s.charAt(0);
        list.add(1);
        for (int i = 1; i < s.length(); i++) {
            //若跟上一个字符相同，则加数
            if (s.charAt(i) == temp){
                list.set(index,list.get(index)+1);
            //不同，则重新加一个数
            }else {
                list.add(1);
                index++;
                temp = s.charAt(i);
            }
        }


        for (int i = 0; i < list.size() - 1; i++) {
            result += Math.min(list.get(i),list.get(i+1));
        }

        return result;

    }
}
