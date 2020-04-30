package medium;

/**
 * leetCode 200 : 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 */
public class T200_numIslands_9_13 {
    private int R;
    private int C;
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0) {
           return 0;
       }
       this.R = grid.length;
       this.C = grid[0].length;
       int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //发现j开始一波
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                   sum ++;
                }
            }
        }
        return sum;
    }

    public void dfs(char[][] grid,int r,int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);



    }
}
