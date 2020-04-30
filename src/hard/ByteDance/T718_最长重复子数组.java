package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/4/8 22:45
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 */
public class T718_最长重复子数组 {
    public static void main(String[] args) {
        int[] n1 = {1,2,3,2,1};
        int[] n2 = {3,2,1,4,7};
        int length = findLength(n1, n2);
        System.out.println(length);
    }
    private static int findLength(int[] A,int[] B) {
        /*int la = A.length;
        int lb = B.length;
        int min = 0;
        int[][] dp = new int[la + 1][lb + 1];
        for (int i = 1; i <= la; i++) {
            for (int j = 1;j <= lb;j ++) {
                //如果两个位置相等
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                min = Math.max(dp[i][j],min);
            }
        }
        return min;*/
        int la = A.length;
        int lb = B.length;
        int min = 0;
        int[] dp = new int[lb + 1];
        for (int i = 1; i <= la; i++) {
            for (int j = 1;j <= lb;j ++) {
                //如果两个位置相等
                if(A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    min = Math.max(dp[i],min);
                }else {
                    dp[j] = 0;
                }

            }
        }
        return min;
    }
}
