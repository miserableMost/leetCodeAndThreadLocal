package medium;

/**
 * leetCode 48 : 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要使用另一个矩阵来旋转图像。
 *
 */
public class T48_rotate_8_29 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ma : matrix) {
            for (int i : ma) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    //先进行转置
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  //如果j从0开始，相当于两次交换==没换
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
     /*   for (int[] ma : matrix) {
            for (int i : ma) {
                System.out.print(i + " ");
            }
            System.out.println();
        }*/
        //列反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
