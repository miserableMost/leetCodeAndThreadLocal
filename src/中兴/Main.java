package 中兴;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/3 9:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long m = n - k + 1;


        for (long i = 1; i <= n; i++) {
            if(i == 1) {
                System.out.print(m);
                if(i != n){
                    System.out.print(" ");
                }
                continue;
            }
            if(i == m) {
                System.out.print(1);
                if(i != n){
                    System.out.print(" ");
                }
                continue;
            }
            if(i != n){
                System.out.print(i + " ");
            }else {
                System.out.println(i);
            }
        }
    }
}
