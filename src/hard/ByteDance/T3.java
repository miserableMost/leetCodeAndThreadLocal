package hard.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/1 17:41
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0;i < n;i ++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] w = new int[m];
        for(int i = 0;i < m;i ++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int i = 0,j = 0,res = 0;
        while(i < n && j < m) {
            if(w[j] >= h[i]) {
                j ++;
                i ++;
                res ++;
            }else {
                j ++;
            }
        }
        System.out.println(res);
    }
}
