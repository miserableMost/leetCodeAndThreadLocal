package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/2/12 19:31
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 */
public class T51_solveNQueens {
    List<List<String>> result = new ArrayList<>();
    public static void main(String[] args) {

    }
    public List<List<String>> solveNQueens(int n) {
        int[][] queen = new int[n][n];
        nQueens(queen,0,n);
        return result;
    }

    private void nQueens(int[][] queen, int index, int n) {
        //当0到n-1行全部放置完成后，输出结果
        if(index == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(queen[i][j] == 0) {
                        sb.append(".");
                    }else {
                        sb.append("Q");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
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
            temp = i + index - n;
            if(temp < 0)
                break;
            if(queue[temp][i] == 1)
                return false;
        }
        //从右上到左下验证
        for (int i = n + 1; i < queue.length; i++) {
            temp = index + n - i;
            if(temp < 0)
                break;
            if(queue[temp][i] == 1)
                return false;
        }
        return true;
    }
}
