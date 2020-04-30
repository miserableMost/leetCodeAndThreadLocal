package Test.July;

import java.util.Arrays;

/**
 * leetCode 217:构造矩形
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
 * 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 *
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W

 */
public class Test492_constructRectangle_7_23 {
    public static void main(String[] args) {
        int[] ints = constructRectangle(0);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] constructRectangle(int area) {
        int diff = Integer.MAX_VALUE;
        int[] res = new int[2];
        if(area == 0)
            return res;
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if(area % i == 0){
                //second为对应的第二个较大的约数
                int second = area / i;
                //保证此次的差值是最小的
                if(second - i < diff){
                    diff = second;
                    //较大的数为长
                    res[0] = second;
                    //较小的数为宽
                    res[1] = i;
                }
            }
        }
        return res;
    }
}
