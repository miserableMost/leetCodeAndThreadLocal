package medium;

/**
 * leetCode 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class T59_generateMatrix_8_30 {
    public static void main(String[] args) {
        int[][] lists = generateMatrix(3);
        for (int[] list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    //右-下-左-上
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0)
            return res;
        boolean[][] visited = new boolean[n][n];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r = 0,c = 0,di = 0;
        for (int i = 1; i <=  n * n; i++) {
            res[r][c] = i;
            visited[r][c] = true;
            int nr = r + dr[di];
            int nc = c + dc[di];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]){
                r = nr;
                c = nc;
            }else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }
}
