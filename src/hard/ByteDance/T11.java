package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/4 21:32
 * 找硬币1-4-16-64
 */
public class T11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sub = N - 1024;
        if(sub == 0)
            System.out.println(0);
        // dp[i] 状态定义为找i元钱，需要的最少张数
        int[] dp = new int[sub + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int[] money = {1,2,16,64};
        for (int i = 1; i <= sub; i++) {
            for (int j = 0; j < money.length; j++) {
                if(i - money[j] >= 0) {
                    dp[i] = Math.min(dp[i - money[j]] + 1,dp[i]);
                }
            }
        }
        System.out.println(dp[sub]);
    }
}
