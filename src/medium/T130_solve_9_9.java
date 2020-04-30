package medium;

/**
 * leetCode 130 : 被包围的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class T130_solve_9_9 {
    public static void main(String[] args) {

    }
    public void solve(char[][] board) {
        int R = board.length;
        if(R == 0)
            return;
        int C = board[0].length;
        //定义上下左右
     /*   int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};*/
        boolean[][] visited = new boolean[R][C];
        //进行深度优先搜索
        //第一行和最后一行
        for (int i = 0; i < C; i++) {
            if(board[0][i] == 'O') {
                dfs(0,i,board,visited);
            }
            if(board[R - 1][i] == 'O') {
                dfs(R - 1,i,board,visited);
            }
        }
        //第一列和最后一列
        for (int i = 1; i < R - 1; i++) {
            if(board[i][0] == 'O') {
                dfs(i,0,board,visited);
            }
            if(board[i][C - 1] == 'O') {
                dfs(i,C - 1,board,visited);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) {
             return;
        }
        if(visited[i][j]) {
            return;
        }
        if(board[i][j] == 'O') {
            visited[i][j] = true;
            dfs(i + 1,j,board,visited);
            dfs(i,j + 1,board,visited);
            dfs(i,j - 1,board,visited);
            dfs(i - 1,j,board,visited);
        }
    }
}
