package medium;

/**
 * leetCode 64 :最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class T64_minPathSum_8_31 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }
    public static int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if(R == 0 || C == 0)
            return 0;
        int sum = grid[0][0];
        //将第一行和第一列进行初始化
        for (int i = 1; i < R; i++) {
            sum += grid[i][0];
            grid[i][0] = sum;
        }
        sum = grid[0][0];
        for (int i = 1; i < C; i++) {
            sum += grid[0][i];
            grid[0][i] = sum;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                //加上一波最小的
                grid[i][j] += Math.min(grid[i - 1][j],grid[i][j - 1]);
            }
        }
        return grid[R - 1][C - 1];
    }
}
