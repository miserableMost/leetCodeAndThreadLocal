package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/30 22:06
 */
public class T65 {
    public static void main(String[] args) {
        T65 t65 = new T65();
        int i = t65.numSum(560);
        System.out.println(i);
    }
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        return helper(0,0,rows,cols,flag,threshold);
    }

    private int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == true) {
            return 0;
        }
        flag[i][j] = true;
        return helper(i-1,j,rows,cols,flag,threshold) + helper(i + 1,j,rows,cols,flag,threshold)
                + helper(i,j - 1,rows,cols,flag,threshold) + helper(i,j + 1,rows,cols,flag,threshold) + 1;
    }

    private int numSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
