package medium;

/**
 * leetCode 79 : 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class T79_exist_9_3 {
    private boolean[][] isUsed;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int R;
    private int C;
    private String word;
    private char[][] board;
    public static void main(String[] args) {

    }
    //二维平面上使用回溯算法
    public boolean exist(char[][] board, String word) {
        R = board.length;
        if(R == 0)
            return false;
        C = board[0].length;
        isUsed = new boolean[R][C];
        this.word = word;
        this.board = board;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //寻找起点
                if (dfs(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if(start == word.length() - 1)
            return board[i][j] == word.charAt(start);
        if(board[i][j] == word.charAt(start)){
            isUsed[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nr = i + direction[k][0];
                int nc = j + direction[k][1];
                //去看下一个点符不符合
                if(inArea(nr,nc) && !isUsed[nr][nc]){
                    if(dfs(nr,nc,start + 1))
                        return true;
                }
            }
            //重置为false
            isUsed[i][j] = false;
        }
        return false;
    }


    public boolean inArea(int x,int y){
        return x >=0 && x < R && y >= 0 && y < C;
    }

}
