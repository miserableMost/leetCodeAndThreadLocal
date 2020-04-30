package medium.T304_NumMatrix_11_4;

/**
 * leetCode 304 : 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 */
public class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
      /*  this.matrix = matrix;*/
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        dp = new int [matrix.length][matrix[0].length + 1];
        //当成m行操作
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        //相当于这个圈里每一行累加
        for (int r = row1; r <= row2; r++) {
            sum += dp[r][col2 + 1] - dp[r][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
    {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(matrix);
        int i = n.sumRegion(2, 1, 4, 3);
        System.out.println(i);


    }

}
