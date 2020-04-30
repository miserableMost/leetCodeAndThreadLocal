package medium;

/**
 * leetCode 36 : 有效的数独
 *判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 *     数字 1-9 在每一行只能出现一次。
 *     数字 1-9 在每一列只能出现一次。
 *     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 *
 */
public class T36_isValidSudoku {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        //记录每行
        boolean[][] row = new boolean[9][9];
        //记录每列
        boolean[][] col = new boolean[9][9];
        //记录九宫格
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';  //获取当前位置的数字
                    int blockIndex = (i / 3) * 3 + j / 3; //当前所在九宫格
                    if(row[i][num] || col[j][num] || block[blockIndex][num]){
                        return false;
                    }else {
                        row[i][num] = true;   //这一行这个数字已经有了
                        col[j][num] = true;  //这一列这个数字已经有了
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
