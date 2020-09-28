package 依图;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/17 18:40
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[][] cost = new int[N][2];
        for (int i = 0; i < N; i++) {
            int Ai = sc.nextInt();
            int Bi = sc.nextInt();
            int Ci = sc.nextInt();
            int Pi = sc.nextInt();
            int spend = Ai * 17 * 29 + Bi * 29 + Ci;
            cost[i][0] = spend;
            cost[i][1] = Pi;
        }
        if(k1 < k2){
            System.out.println("YES");
            System.out.println("0 0 0");
            return;
        }
        int money = x * 17 * 29 + y * 29 + z;
        boolean win = false;
        int sub = 0;
        Arrays.sort(cost,(n1,n2)->n1[0] - n2[0]);
        for (int i = 0; i < cost.length; i++) {
            if(cost[i][1] + k2 > k1 && money >= cost[i][0]){
                win = true;
                sub = money - cost[i][0];
                break;
            }
        }
        if(win){
            System.out.println("YES");
            int a = sub / (17 * 29);
            sub -= a * 17 * 29;
            int b = sub / 29;
            sub -= b * 29;
            System.out.print(a + " " + b + " " + sub);
        }else{
            System.out.println("NO");
        }


    }
}
