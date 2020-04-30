package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 868:二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *
 * 如果没有两个连续的 1，返回 0 。
 */
public class Test868_binaryGap_7_22 {

    public static void main(String[] args) {
        System.out.println(binaryGap2(1));
    }

    public static int binaryGap(int N) {
        String n = Integer.toBinaryString(N);
        List<Integer> list = new ArrayList<>();
        int length = n.length();
        int dis = 0;
        for (int i = 0; i < length; i++) {
            if (n.charAt(i) == '1') {
                list.add(i);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) > dis) {
                dis = list.get(i) - list.get(i - 1);
            }
        }
        return dis;
    }
    public static int binaryGap2(int N){
        //将十进制转成二进制字符串
        String n = Integer.toBinaryString(N);
        int res = 0;
        //定义最近的上一个1的位置
        int last = 0;
        int length = n.length();
        for (int i = 1; i < length; i++) {
             if (n.charAt(i) == '1'){

                 res = Math.max(res,i - last);
                 //更新最近的上一个1的位置
                 last = i;
             }

        }
        return res;
    }
}