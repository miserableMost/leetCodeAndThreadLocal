package PSoffer;

import java.util.ArrayList;

/**
 * @author 李聪
 * @date 2019/12/22 10:52
 * 顺时针打印矩阵
 */
public class T18 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix[0].length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        //定义一个右，下，左，上的二维矩阵
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        boolean[][] isVisited = new boolean[m][n];
        int r = 0,c = 0,d = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[r][c]);
            isVisited[r][c] = true;
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(isArea(matrix,nr,nc) && !isVisited[nr][nc]) {  //此时无须转向
                r = nr;
                c = nc;
            }else {
                d = (d + 1) % 4;
                r += dir[d][0];
                c += dir[d][1];
            }
        }
        return res;
        /*for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < dir.length; k++) {
                    int newI = i + dir[k][0];
                    int newJ = j + dir[k][1];
                    if(isArea(matrix,newI,newJ) && !isVisited[newI][newJ]){
                        res.add(matrix[newI][newJ]);
                        isVisited[newI][newJ] = true;
                    }
                }
            }
        }*/
    }
    private boolean isArea(int[][] matrix,int i,int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(i >= 0 && i < m && j >= 0 && j < n)
            return true;
        return false;
    }
}
