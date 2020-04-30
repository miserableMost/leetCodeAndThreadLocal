package newTest.dfs;

/**
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]
 */
public class T329_longestIncreasingPath_9_16 {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private int m,n;
    public static void main(String[] args) {

    }
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        int ans = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans,dfs(matrix,i,j,cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] martix,int i,int j,int[][] cache) {
        if(cache[i][j] != 0)
            return cache[i][j];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = i + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n) {
                cache[i][j] = Math.max(cache[i][j],dfs(martix,x,y,cache));
            }
        }
        return cache[i][j] ++;
    }
}
