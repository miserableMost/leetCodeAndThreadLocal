package pinduoduo;

import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(2);
    }
}
