package tryTest;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/26 14:52
 */
public class 猿辅导1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int Mod = 1000000007;
        int[][] dp = new int[N + 1][2];
        //0表示在手里，1表示不在手里
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % Mod;
            dp[i][1] = dp[i - 1][1] * (K - 2) % Mod + dp[i - 1][0]*(K - 1)%Mod;
;        }
        System.out.println(dp[N][0]);
    }
}
