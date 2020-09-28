package xiaomi;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/8 17:37
 */
public class Main2 {
    private static boolean[][] vistied = new boolean[3][4];
    private  int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    private   int m = 3,n = 4;

    private static  char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Main2 m = new Main2();

        System.out.println(m.exist(board,s));
    }




    //下面是我写的方法
    public boolean exist(char[][] board,String word){
        if(board == null || board.length == 0)
            return false;

       // vistied = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index,String word) {
        if(index == word.length() - 1){
            return board[i][j] == word.charAt(index);
        }
        if(board[i][j] == word.charAt(index)){
            vistied[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dir[k][0];
                int nj = j + dir[k][1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && !vistied[ni][nj]){
                    if(dfs(ni,nj,index + 1,word)){
                        return true;
                    }
                }
            }
            vistied[i][j] = false;
        }
        return false;
    }
}
