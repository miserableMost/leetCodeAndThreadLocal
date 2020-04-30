package medium;

/**
 * leetCode  74 : 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 *     每行中的整数从左到右按升序排列。
 *     每行的第一个整数大于前一行的最后一个整数。
 *  matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 **/
public class T74_searchMatrix_9_2 {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        boolean b = searchMatrix(matrix, 1);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
         if(matrix == null || matrix.length == 0)
             return false;
         int R = matrix.length;
         int C = matrix[0].length;
         if(R == 0 || C == 0)
             return false;
         int i = 0,j = C - 1;
         //从第一行最后一个数开始，数组值小于目标值向下移动，数组值大于目标值向左移动
         while(i <= R - 1 && j >= 0){
             if(target == matrix[i][j]){
                 return true;
             }else if(target < matrix[i][j]){
                 //往左移
                 j --;

             }else if(target > matrix[i][j]){
                 //往下移
                 i ++;
             }
         }
         return false;
    }

}
