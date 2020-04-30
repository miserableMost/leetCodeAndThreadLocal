package Test.July;

import java.util.Arrays;

/**
 * leetCode 832:翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
。
 */
public class Test832_flipAndInvertImage_29 {
    public static void main(String[] args) {
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] result = flipAndInvertImage(A);
        /*for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }*/
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int length = A[0].length;
        for (int i = 0; i < A.length; i++) {
            int length2 = length - 1;
            for (int j = 0; j < length / 2; j++) {
                int temp = 0;
                temp  = A[i][j];

                A[i][j] = A[i][length2];
                A[i][length2--] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

}
