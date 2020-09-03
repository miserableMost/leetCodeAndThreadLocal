package meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i][0] + 2 * arr[i][1];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2) -> {
            return tmp[n1] - tmp[n2] == 0 ? n2 - n1 : tmp[n1] - tmp[n2];
        });
        for (int i = 0; i < tmp.length; i++) {
            queue.add(i);
            if(queue.size() > m) {
                queue.poll();
            }
        }
        int[] ans = new int[m];
        int idx = 0;
        while(!queue.isEmpty()){
            ans[idx ++] = queue.poll();
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            if(i == ans.length - 1) {
                System.out.print(ans[i] + 1);
            }else {
                System.out.print(ans[i] + 1);
                System.out.print(" ");
            }
        }
    }
}
