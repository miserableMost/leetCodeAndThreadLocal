package vivo;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/12 20:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        int i1 = Integer.parseInt(arr[0]);
        int j1 = Integer.parseInt(arr[1]);
        int i2 = Integer.parseInt(arr[2]);
        int j2 = Integer.parseInt(arr[3]);
        char[][] charArr = new char[m][m];
        for (int i = 0; i < m; i++) {
            charArr[i] = sc.nextLine().toCharArray();
        }
        int ans = 0;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        /*for (int i = 0; i < m; i++) {

        }*/
        while(i1 >= 0 && i1 < m && j1 >= 0 && j1 < m){
            if(i1 == j1 && i2 == j2){
                break;
            }
        }
        System.out.println(-1);
    }
}
