package Test.August;

/**
 * leetCode 840 :矩阵中的幻方
 */
public class D3_numMagicSquaresInside_840 {
    public static void main(String[] args) {

    }
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        //小于 3X3的直接剔除
        if (row<3 || col<3) return num;

        for (int i=0;i<row-1;i++) {
            //优先行遍历，若超出范围说明已经遍历完毕直接返回
            if(i+2 >= row) return num;

            for (int j=0;j < col-1;j++) {
                //若列遍历超出范围，break继续下一行遍历
                if (j+2 >= col) {
                    break;
                }
                //找出计算符合条件的幻阵
                if ((grid[i][j+1] + grid[i][j+2] == grid[i+1][j] + grid[i+2][j])
                        && (grid[i][j+1] + grid[i][j+2] == grid[i+1][j+1] + grid[i+2][j+2])
                ) {
                    //剔除不符合界限条件的，如1-9不重复
                    boolean flag = true;
                    int isTrue[] = new int[9];
                    for(int g=0;g<3;g++) {
                        for(int k=0;k<3;k++) {
                            if (grid[i+g][j+k] <= 0 || grid[i+g][j+k] > 9)
                                flag = false;
                            else
                                isTrue[grid[i+g][j+k]-1] = 1;
                        }
                    }

                    for (int l=0;l < isTrue.length;l++) {
                        if (isTrue[l] == 0) flag = false;
                    }

                    if (flag)
                        num++;
                }
            }
        }
        return num;

    }
}
