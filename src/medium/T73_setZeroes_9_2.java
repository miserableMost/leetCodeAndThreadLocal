package medium;

/**
 * leetCode 73 : 矩阵置0
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class T73_setZeroes_9_2 {
    public static void main(String[] args) {
        int[][] res = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(res);
        for (int[] r : res) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        int R = matrix.length;
        int C = matrix[0].length;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        //用来记录是否是假的0
        boolean[][] falseZero = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(matrix[i][j] == 0 && falseZero[i][j] == false){
                    //将上下左右都设置为0
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        while(nr >= 0 && nr < R && nc >= 0 && nc < C){
                            if(matrix[nr][nc] != 0){
                                matrix[nr][nc] = 0;
                                //标记为后来操作变成的0
                                falseZero[nr][nc] = true;
                            }
                            nr += dr[k];
                            nc += dc[k];
                        }
                    }
                }
            }
        }
    }

}
