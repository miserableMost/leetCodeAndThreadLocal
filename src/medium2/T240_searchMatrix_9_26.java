package medium2;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 */
public class T240_searchMatrix_9_26 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean b = searchMatrix(matrix, 20);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        if (R == 0)
            return false;
        int C = matrix[0].length;
        int i = 0,j = C - 1;
        while(j >= 0 && i <= R - 1) {
            if(target > matrix[i][j]) {  //目标比当前数大
                i ++;
            }else if(target < matrix[i][j]) {  //目标比当前小
                j --;
            }else if(target == matrix[i][j]) {
                return true;
            }
        }
        return false;
    }
}
