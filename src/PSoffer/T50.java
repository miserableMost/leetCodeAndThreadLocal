package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 10:53
 */
public class T50 {
    public static void main(String[] args) {

    }
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length == 0)
            return B;
        //计算下三角连乘
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //计算上三角连乘
        int temp = 1;  //temp即便是右边的和
        for (int i = A.length - 2; i >= 0; i--) {

            temp *=  A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
