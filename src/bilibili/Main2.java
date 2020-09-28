package bilibili;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/9/4 18:37
 */
public class Main2 {
    public static void main(String[] args) {
        Main2 m2 = new Main2();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = m2.SpiralMatrix(m);
        System.out.println(Arrays.toString(ints));

    }
    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visitied = new boolean[m][n];
        int r = 0,c = 0,k = 0,idx = 0;
        for (int i = 0; i < m * n; i++) {
            ans[idx] = matrix[r][c];
            idx ++;
            visitied[r][c] = true;
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr < m && nr >= 0 && nc < n && nc >= 0 && !visitied[nr][nc]){
                r = nr;
                c = nc;
            }else {
                k = (k + 1) % 4;
                r = r + dir[k][0];
                c = c + dir[k][1];
            }
        }
        return ans;
    }
}
