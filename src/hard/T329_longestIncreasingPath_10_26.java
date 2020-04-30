package hard;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 */
public class T329_longestIncreasingPath_10_26 {

    private int[][] matrix;
    private int R;
    private int C;

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        T329_longestIncreasingPath_10_26 test = new T329_longestIncreasingPath_10_26();
        int i = test.longestIncreasingPath(matrix);
        System.out.println(i);
    }
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        this.matrix = matrix;
        this.R = matrix.length;
        this.C = matrix[0].length;
        //定义一个缓存
        int[][] cache = new int[R][C];
        //定义一个上下左右的移动数组
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
        //定义一个返回结果
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans = Math.max(ans,dfs(cache,i,j,dirs));
            }
        }
        return ans;
    }

    private int dfs(int[][] cache, int i, int j,int[][] dirs) {
        if(cache[i][j] != 0)     //如果缓存中有，则从缓存中取
            return cache[i][j];
        for (int k = 0; k < 4; k++) {
            int nr = i + dirs[k][0];
            int nc = j + dirs[k][1];
            if(nr >= 0 && nr < R && nc >=0 && nc < C && matrix[nr][nc] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j],dfs(cache,nr,nc,dirs));
            }
        }
        //cache[i][j]必须先增加
       /* cache[i][j] += 1;*/
        //不管何方向都得加上我这个
        return   ++cache[i][j];
    }
}
