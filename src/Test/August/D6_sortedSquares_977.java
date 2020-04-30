package Test.August;

import java.util.Arrays;

/**
 * leetCode 977: 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class D6_sortedSquares_977 {
    public static void main(String[] args) {
        int[] A = {-4,-1,0,3,10};
        int[] res = sortedSquares(A);
        System.out.println(Arrays.toString(res));
    }
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }
}
