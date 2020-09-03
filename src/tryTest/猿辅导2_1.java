package tryTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/27 22:59
 */
public class 猿辅导2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n];
        for (int i = 0; i <n; i++) {
            dp[i] = sc.nextInt();
        }
        if(n <= m) {
            for (int i = 0; i < n; i++) {
                if(i != n) {
                    System.out.print(dp[i] + " ");
                }else {
                    System.out.print(dp[i]);
                }
            }
            return;
        }
        int sub = n % m;
        int j = n - sub;
        List<Integer> ans = new ArrayList<>();
        for (int i = j; i < n; i++) {
            ans.add(dp[i]);
        }
        j = j - m;
        while(j >= 0) {
            int i = j;
            for (int k = 0; k < m; k++) {
                ans.add(dp[i]);
                i ++;
            }
            j = j - m;
        }
        for (int i = 0; i < ans.size(); i++) {
            if(i != ans.size()) {
                System.out.print(ans.get(i) + " ");
            }else {
                System.out.println(ans.get(i));
            }
        }
    }
}
