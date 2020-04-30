package medium2;

/**
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 *     如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *     如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *     如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *     如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class T289_gameOfLife_9_27 {
    private int R;
    private int C;
    public static void main(String[] args) {
        int[][] ans = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        T289_gameOfLife_9_27 test = new T289_gameOfLife_9_27();
        test.gameOfLife(ans);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public void gameOfLife(int[][] board) {
        this.R = board.length;
        this.C = R == 0 ? 0 : board[0].length;
        int[][] pos = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] isChanged = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 0) {
                    //当前位置是死细胞
                    int count = count(pos, i, j, board, isChanged);
                    if(count == 3) {
                        board[i][j] = 1;
                        isChanged[i][j] = true;
                    }
                }else {
                    int count = count(pos, i, j, board, isChanged);
                    if(count < 2 || count > 3) {
                        board[i][j] = 0;
                        isChanged[i][j] = true;
                    }
                }
            }
        }

    }

    public boolean inArea(int i,int j) {
        return (i >= 0 && i < R && j >= 0 && j < C);
    }

    private int count(int[][] pos,int i,int j,int[][] board,boolean[][] isChanged) {
        int count = 0;
        for (int k = 0; k < pos.length; k++) {
            int nr = i + pos[k][0];
            int nc = j + pos[k][1];
            //活细胞包括现在的活且没被改过或者现在的死已被改过
            if (inArea(nr, nc) && ((board[nr][nc] == 1 && !isChanged[nr][nc]) || (board[nr][nc] == 0 && isChanged[nr][nc] == true))) {
                count++;
            }
        }
        return count;
    }
  /*  //进阶
    public void gameOfLife2(int[][] board) {
        this.R = board.length;
        this.C = R == 0 ? 0 : board[0].length;
        int[][] pos = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] isVisit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 0) {
                    //当前位置是死细胞
                    int count = 0;  //计算附近的活细胞
                    for (int k = 0; k < pos.length; k++) {
                        int nr = i + pos[k][0];
                        int nc = j + pos[k][1];
                        if(inArea(nr,nc) && board[nr][nc] == 1) {
                            count ++;
                        }

                    }
                    if(count == 3) {

                        isVisit[i][j] = true;

                    }
                }else {
                    int count = 0;
                    for (int k = 0; k < pos.length; k++) {
                        int nr = i + pos[k][0];
                        int nc = j + pos[k][1];
                        if (inArea(nr, nc) && board[nr][nc] == 1) {
                            count++;
                        }
                    }
                    if(count < 2 || count > 3) {

                        isVisit[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(isVisit[i][j]) {
                    board[i][j] = board[i][j] == 1 ? 0 : 1;
                }
            }
        }

    }

    public boolean inArea(int i,int j) {
        return (i >= 0 && i < R && j >= 0 && j < C);
    }
*/
}
