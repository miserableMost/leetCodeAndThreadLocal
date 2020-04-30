package Test.June;

/** leetCode867 : 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 1 <= A.length <= 1000
 1 <= A[0].length <= 1000
 */
public class Test867_transpose {

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] result = transpose(A);
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] A) {
        //原矩阵的行数
        int row = A.length;
        //原矩阵的列数
        int column = A[0].length;
        //返回结果
        int[][]result = new int[column][row];
        //将原矩阵的行赋给新数组的列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
