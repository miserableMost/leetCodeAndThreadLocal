package Test.July;

/**
 * leetCode999:  车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class Test999_numRookCaptures {

    public static void main(String[] args) {
          char[][] b = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},
                  {'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},
                  {'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
           System.out.println(numRookCaptures(b));
    }

    public static int numRookCaptures(char[][] board) {
        //先找到车
        int m = 0,n = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R'){
                    m = i;
                    n = j;
                    break;
                }
            }
        }
        //白色车R、空方块. 、白色的象B 、卒p
        //定义一个变量记录总数
        int count = 0;
        //先找北方向
        int p1 = m,p2 = n;
        while(m > 0){
            m--;
            if(board[m][n] == 'B'){
                break;
            }
            if(board[m][n] == 'p'){
                count ++;
                break;
            }
        }
        //恢复m的值
        m = p1;
        //再找西方向
        while(n > 0){
            n --;
            if(board[m][n] == 'B'){
                break;
            }
            if(board[m][n] == 'p'){
                count ++;
                break;
            }
        }
        //恢复n的值
        n = p2;
        //再找东方向
        while(n < board[0].length - 1){
            n ++;
            if(board[m][n] == 'B'){
                break;
            }
            if(board[m][n] == 'p'){
                count ++;
                break;
            }
        }
        n = p2;
        //再找南方向
        while(m < board.length -1){
            m ++;
            if(board[m][n] == 'B'){
                break;
            }
            if(board[m][n] == 'p'){
                count ++;
                break;
            }
        }
        return count;
    }
}
