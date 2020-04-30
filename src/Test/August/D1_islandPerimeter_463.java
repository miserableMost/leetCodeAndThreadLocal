package Test.August;

/**
 * leetCode 463 :岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 */
public class D1_islandPerimeter_463 {

    public static void main(String[] args) {
        int[][] res  = {{1},{0}};
        int i = islandPerimeter(res);
        System.out.println(i);
    }
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j] == 1){
                    count += 4;
                   /* //向上重合了
                    if(i > 0 && grid[i -1][j] == 1)
                        count -= 1;
                    //向下重合
                    if(i < row - 1 && grid[i + 1][j] == 1)
                        count -= 1;
                    //向左重合
                    if(j > 0 && grid[i][j - 1] == 1)
                        count -= 1;
                    //向右重合
                    if(j < column - 1 && grid[i][j + 1] == 1)
                        count -= 1;*/
                   //只计算上左--避免重复
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }

            }
        }
        return count;
    }
}
