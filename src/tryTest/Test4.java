package tryTest;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/23 23:10
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int l = 0,r = 0,sum = 0,ans = 0;

        while(r < arr.length) {
            sum += arr[r];
            while(sum > s) {
                sum -= arr[l];
                l ++;
            }
            if(r - l + 1 > ans) {

                ans = r - l + 1;
            }
            r ++;
        }

        System.out.println(ans);
    }
}
