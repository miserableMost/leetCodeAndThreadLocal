package findJob.first.passvalue_code;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2019/12/1 19:55
 */

/**
 * 方法的传参机制：
 * 基本数据类型传递时：
 * 数据值
 * 引用数据类型：
 * 传递地址值
 * 其中字符串对象，包装类等对象不可变
 */
public class Exam4 {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1,2,3,4,5};
        MyData my = new MyData();
        change(i,str,num,arr,my);
        System.out.println("i=" + i);
        System.out.println("str=" + str);
        System.out.println("num=" + num);
        System.out.println("arr=" + Arrays.toString(arr));
        System.out.println("my.a=" + my.a);
    }

    private static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}