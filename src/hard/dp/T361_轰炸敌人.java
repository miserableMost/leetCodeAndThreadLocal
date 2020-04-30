package hard.dp;

/**
 * @author 李聪
 * @date 2020/4/10 19:55
 * 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
 *
 *     'W' 表示一堵墙
 *     'E' 表示一个敌人
 *     '0'（数字 0）表示一个空位
 *     请你计算一个炸弹最多能炸多少敌人。
 *
 * 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
 *
 * 注意：你只能把炸弹放在一个空的格子里
 *
 *
 */
public class T361_轰炸敌人 {
    public static void main(String[] args) {

    }
    public int maxKilledEnemies(char[][] grid) {
        // dp
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int R = grid.length;
        int C = grid[0].length;

        int [][]up = new int[R][C];
        int [][]down = new int[R][C];
        int [][]left = new int[R][C];
        int [][]right = new int[R][C];

        int res = 0;
        // 上方
        for(int i=0; i<R; ++i)
            for(int j=0; j<C; ++j){
                if(grid[i][j] == 'W'){
                    up[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1: 0;
                if(i > 0)
                    up[i][j] += up[i-1][j];
            }
        // 下方
        for(int i=R-1; i>=0; --i)
            for(int j=0; j<C; ++j){
                if(grid[i][j] == 'W'){
                    down[i][j] = 0;
                    continue;
                }
                down[i][j] = grid[i][j] == 'E' ? 1: 0;
                if(i < R-1)
                    down[i][j] += down[i+1][j];
            }
        // 左方
        for(int i=0; i<R; ++i)
            for(int j=0; j<C; ++j){
                if(grid[i][j] == 'W'){
                    left[i][j] = 0;
                    continue;
                }
                left[i][j] = grid[i][j] == 'E' ? 1: 0;
                if(j > 0)
                    left[i][j] += left[i][j-1];
            }
        // 右方
        for(int i=0; i<R; ++i)
            for(int j=C-1; j>=0; --j){
                if(grid[i][j] == 'W'){
                    right[i][j] = 0;
                    continue;
                }
                right[i][j] = grid[i][j] == 'E' ? 1: 0;
                if(j < C-1)
                    right[i][j] += right[i][j+1];
            }

        // start
        for(int i=0; i<R; ++i)
            for(int j=0; j<C; ++j)
                if(grid[i][j]=='0'){
                    int t = up[i][j]+down[i][j]+right[i][j]+left[i][j];
                    res = Math.max(res, t);
                }
        return res;
    }

}
