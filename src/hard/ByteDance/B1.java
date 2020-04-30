package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/2 22:52
 */
public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];
        final int mod = (int) (Math.pow(10,9) + 7);
        for (int i = 1; i <= n ;i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 2;i <= n + 1;i++) {
            //第一次到达i - 1，回退到p[i - 1],从p[i-1]门回到i-1门，此时p[i-1]门到达奇数次，其他所有门到达偶数次
            //这和第一次到达p[i-1]门的情况完全相同,需要dp[i-1]-dp[p[i-1]]
            dp[i] = (dp[i - 1] + 1) + dp[i - 1] - dp[p[i - 1]] + 1;
            if(dp[i] < 0)
                dp[i] += mod;
            else if(dp[i] >= mod)
                dp[i] %= mod;
        }
        System.out.println(dp[n + 1]);

    }
}
