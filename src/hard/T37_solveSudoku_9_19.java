package hard;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 *     数字 1-9 在每一行只能出现一次。
 *     数字 1-9 在每一列只能出现一次。
 *     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 空白格用 '.' 表示。
 *
 */
public class T37_solveSudoku_9_19 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        T37_solveSudoku_9_19 test = new T37_solveSudoku_9_19();
        test.solveSudoku(board);
        test.printBoard(board);

    }
    //将数组分成九个九宫格
    public void solveSudoku(char[][] board) {
        //记录行
        boolean[][] row = new boolean[9][10];
        //记录列
        boolean[][] col = new boolean[9][10];
        //记录boxs
        boolean[][] boxs = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int n =  board[i][j] - '0';
                    row[i][n] = true;
                    col[j][n] = true;
                    //计算属于哪个方块
                    int idx = (i / 3) * 3 + j / 3;
                    boxs[idx][n] = true;
                }
            }
        }
        dfs(board,row,col,boxs,0,0);

    }
    //返回boolean判断这一波操作能否成功
    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] boxs,int i,int j) {
        //找到空位置
        while(board[i][j] != '.') {
            if(++ j >= 9) {
                i++;
                j = 0;
            }
            if(i >= 9)
                return true;
        }

        for (int num = 1; num <= 9; num++) {
            int idx = i / 3 * 3 + j / 3;
            if(!row[i][num] && !col[j][num] && !boxs[idx][num]) {
                //递归
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                boxs[idx][num] = true;
                if(dfs(board,row,col,boxs,i,j)) {
                    return true;
                }else {
                    //回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    boxs[idx][num] = false;
                    board[i][j] = '.';
                }

            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
