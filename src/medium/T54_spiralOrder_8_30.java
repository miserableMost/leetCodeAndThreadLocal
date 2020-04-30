package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class T54_spiralOrder_8_30 {
    public static void main(String[] args) {

    }
     //右->下->左->上
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<>();
         //建立一个数组代表访问过没
         int R = matrix.length;
         if(R == 0)
             return ans;
         int C = matrix[0].length;
         boolean[][] visited = new boolean[R][C];
         int[] dr = {0,1,0,-1};
         int[] dc = {1,0,-1,0};
         int r = 0,c = 0,di = 0;   //di指示下一个元素
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dr[di];
            int nc = c + dc[di];
            if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]){   //此时未进行转向
                r = nr;
                c = nc;
            }else {
                di = (di + 1) % 4;   //选择如何转向
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
     }
}
