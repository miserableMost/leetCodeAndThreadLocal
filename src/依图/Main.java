package 依图;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/17 18:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        double ans = 0;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            int subTi = arr[i][0] - arr[i - 1][0];
            double len = Math.pow(arr[i][1] - arr[i - 1][1],2) + Math.pow(arr[i][2] - arr[i - 1][2],2) + Math.pow(arr[i][3] - arr[i - 1][3],2);
            double cur = len / subTi;
            if(cur > ans){
                ans = cur;
                res = i;
            }
        }
        System.out.println(res);
    }
}
