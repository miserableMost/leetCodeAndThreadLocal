package Test.August;

import java.util.Arrays;

/**
 * leetCode 908 : 最小差值
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 */
public class D6_smallestRangeI_908 {
    public static void main(String[] args) {

    }
    //理解题目理解了半天，这题的重点在最大值与最小值的差值与2*K的值比较，
    // 如果这个差值比2*K还要大，则所有元素无论怎么调整，
    // 新数组最大最小的差值也只能是max-min-2*k，但如果这个差值比2*k要小，
    // 则一定可以调整所有元素为一样的元素，此时新数组最大最小的差值就是0啦。
    public int smallestRangeI(int[] A, int K) {

        Arrays.sort(A);
        return A[A.length-1] - A[0] > 2*K ? A[A.length-1] - A[0] - 2*K : 0 ;
    }
}
