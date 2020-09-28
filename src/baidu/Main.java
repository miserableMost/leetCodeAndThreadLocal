package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/14 18:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] want = new int[n];
            int[] real = new int[m];
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                want[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                real[j] = sc.nextInt();
            }
            //Arrays.sort(want);
            Arrays.sort(real);
            for (int j = 0; j < want.length; j++) {
                int privot = want[j];
                int index = searchFirst(real,privot);

                ans[j] = m - index;
            }
            for (int j = 0; j < ans.length; j++) {
                if(j != ans.length - 1){
                    System.out.print(ans[j] + " ");
                }else {
                    System.out.print(ans[j]);
                }
            }
        }
    }

    private static int searchFirst(int[] real, int privot) {
        int low = 0,high = real.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(real[mid] >= privot) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return real[low] >= privot ? low : real.length;
    }
}
