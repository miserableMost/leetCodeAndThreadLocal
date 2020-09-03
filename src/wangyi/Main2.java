package wangyi;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/8 14:44
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int diff = n - m;
        int first = arr[0];
        int last = arr[m - 1];
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < ans.length; i++) {
            if(i != ans.length - 1){
                System.out.print(ans[i] + " ");
            }else {
                System.out.print(ans[i]);
            }
        }
    }
}
