package hard;

/**
 * @author 李聪
 * @date 2020/2/12 21:26
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量
 */
public class T52_totalNQueens {
    private int result = 0;
    public static void main(String[] args) {

    }
    public int totalNQueens(int n) {
        int[][] queen = new int[n][n];
        nQueens(queen,0,n);
        return result;
    }
    private void nQueens(int[][] queen, int index, int n) {
        //当0到n-1行全部放置完成后，输出结果
        if(index == n) {
             result ++;
            return;
        }
        //验证第index行第i位是否合法
        for (int i = 0; i < n; i++) {
            if(isQueen(queen,index,i)) {
                queen[index][i] = 1;  //放置棋子
                nQueens(queen,index + 1,n);  //开始放置下一行
                queen[index][i] = 0;        //还原棋盘
            }
        }
    }

    private Boolean isQueen(int[][] queue,int index,int n) {
        //纵向验证
        for (int i = 0; i < index; i++) {
            if(queue[i][n] == 1) {
                return false;
            }
        }
        int temp = 0;
        //从左上到右下斜方向验证
        for (int i = n - 1; i >= 0; i--) {
            temp = i + index - n;   //行 - 列（temp - i) 是一个常数为index - n
            if(temp < 0)
                break;
            if(queue[temp][i] == 1)
                return false;
        }
        //从右上到左下验证
        for (int i = n + 1; i < queue.length; i++) {
            temp = index + n - i;  //行 + 列（temp + i）是一个常数为index + n
            if(temp < 0)
                break;
            if(queue[temp][i] == 1)
                return false;
        }
        return true;
    }
}
