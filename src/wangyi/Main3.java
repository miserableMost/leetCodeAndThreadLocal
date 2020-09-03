package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/8 14:44
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[0]);
        }


    }
}
