package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode401 :二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧
 */
public class Test401_readBinaryWatch_7_23_REMEMBER {

    public static void main(String[] args) {
        List<String> str = readBinaryWatch(1);
        for (String s : str) {
            System.out.print(s+" ");
        }
    }

    public static List<String> readBinaryWatch(int num){
        List<String> res = new ArrayList<>();
        //将所有可显示的情况全部遍历
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                //计算此次i、j中1的总和是否与num相等
                if(Integer.bitCount((i<<6) | j) == num){
                    //若分为个位数，前面补0
                    res.add(i+":"+(j > 9 ? "":"0")+j);
                }
            }
        }
        return res;
    }
}
