package pinduoduo;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = sc.nextInt();
        }
        if(K == 0){
            System.out.println("paradox");
            return;
        }
        if(N == 0){
            System.out.println(K + "" + 0);
            return;
        }
        int back = 0;
        for (int i = 0; i < N; i++) {
            //在第N次筛子之前
            if(dp[i] == K) {
                if(i != N - 1){
                    System.out.println("paradox");
                    return;
                }else {
                    K = 0;
                }
            }else if(dp[i] < K) {
                K -= dp[i];

            }else if(dp[i] > K) {
                //需要回退
                K = dp[i] - K;
                back ++;
            }
        }
        System.out.println(K + " " + back);
    }
}
