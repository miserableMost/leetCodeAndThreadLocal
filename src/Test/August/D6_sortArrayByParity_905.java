package Test.August;

import java.util.Arrays;

/**
 * leetCode 905 : 按奇偶排列数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 */
public class D6_sortArrayByParity_905 {
    public static void main(String[] args) {
         int[] A = {3,1,2,4};
        int[] res = sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }
    public static int[] sortArrayByParity(int[] A) {
         int len = A.length;
         int[] temp = new int[len];
         int start = 0;
         int end = len - 1;
        for (int i = 0; i < len;i++) {
            if(A[i] % 2 == 0){
                temp[start ++] = A[i];
            } else{
                temp[end --] = A[i];
            }


        }
        return temp;
    }
}
