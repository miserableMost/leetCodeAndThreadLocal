package pinduoduo;

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[6][6];
        for (int i = 0; i < 6; i++) {
            String cur = sc.nextLine();
            arr[i] = cur.toCharArray();
        }
        int mod = 1000000009;
        int[][][] dp = new int[7][7][6];
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][0][j] = dp[i - 1][0][j] == 0 ? 1 : 0;
            }
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                dp[0][i][j] = dp[0][i - 1][j] == 0 ? 1 : 0;
            }
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if(arr[i - 1][j - 1] == '*'){
                    for (int k = 0; k < 6; k++) {
                        int sum = 0;
                        for (int l = 0; l < 6; l++) {
                            if(k == l){
                                continue;
                            }
                            sum += dp[i - 1][j][l];
                            for (int m = 0; m < 6; m++) {
                                if(m == k)
                                    continue;
                                //上面的方案加上左边的方案
                                sum += dp[i][j - 1][m];
                            }

                        }
                        dp[i][j][k] = sum;
                    }
                }

            }
        }
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += dp[6][6][i];
        }
        System.out.println(36);
        System.out.println(sum % mod);
    }
}
