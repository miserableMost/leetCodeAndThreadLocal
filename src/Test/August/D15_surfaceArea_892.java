package Test.August;

/**
 * leetCode 892 : 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 */
public class D15_surfaceArea_892 {
    public static void main(String[] args) {

    }
    //让我们试着计算 v = grid[i][j] 所贡献的表面积。
    //上下必然有，东西南北四个面可能重合
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1}; //上下行
        int[] dc = new int[]{1, 0, -1, 0}; //左右列
        int N = grid.length;
        int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(grid[r][c] > 0){
                    //先加上下
                    ans += 2;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N)
                            nv = grid[nr][nc];
                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }
        return ans;

    }
}
