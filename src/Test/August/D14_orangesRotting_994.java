package Test.August;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * leetCode 994 : 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 *     值 0 代表空单元格；
 *     值 1 代表新鲜橘子；
 *     值 2 代表腐烂的橘子。
 *
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1
 *
 */
public class D14_orangesRotting_994 {
    //用于遍历上下左右
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grid) {
        int R = grid.length,C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();    //用于存放腐烂的橘子的位置
        Map<Integer,Integer> depth = new HashMap<>();   //计算是第几次腐烂
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(grid[r][c] == 2){
                    //如果橘子已经腐烂
                    int code = r * C + c;    //用于标识它的位置
                    queue.add(code);
                    depth.put(code,0);
                }
            }
        }
        //BFS:先把最初腐烂的橘子加入队列，不断更新队列，用depth标记是第几波加入的
        int ans = 0;
        while(!queue.isEmpty()){
            int code = queue.remove();   //从队列中取出腐烂的橘子
            int r = code / C,c = code % C;
            for (int i = 0; i < 4; i++) {   //依次遍历上下左右
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;   //标识在队列中的位置
                    queue.add(ncode);  //加入队列
                    depth.put(ncode,depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if(v == 1)
                    return -1;
            }
        }
        return ans;
    }
}
