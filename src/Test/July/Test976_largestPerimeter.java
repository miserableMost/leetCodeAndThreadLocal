package Test.July;

import java.util.Arrays;

/**
 * leetCode 976:三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
public class Test976_largestPerimeter {
    public static void main(String[] args) {
          int[] a = {3,6,2,3};
        System.out.println(largestPerimeter(a));
    }
    public static int largestPerimeter(int[] A) {
        //先将数组排序
        Arrays.sort(A);
        int length = A.length;
        int a = 0,b = 0,c = 0;
        int res = 0,sum = 0;

        for (int i = length - 1; i >= 2; i--) {
            //每次选择数组中最大的三个元素，看是否满足三角形组成条件
            a = A[i];
            b = A[i-1];
            c = A[i-2];
            res = b + c;
            //两个较小边大于第三边，则必然满足
            if(res > a){
                //计算周长
                sum = a + b + c;
                break;
            }

        }
        return sum;
     }
}
