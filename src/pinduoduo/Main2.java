package pinduoduo;

import java.util.Arrays;
        import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int N = Integer.valueOf(s1[0]);
        int M = Integer.valueOf(s1[1]);
        int T = Integer.valueOf(s1[2]);
        //记录中餐的
        int[][] lunch = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] cur = sc.nextLine().split(" ");
            lunch[i][0] = Integer.valueOf(cur[0]);
            lunch[i][1] = Integer.valueOf(cur[1]);
        }
        //记录晚餐的
        int[][] later = new int[M][M];
        for (int i = 0; i < M; i++) {
            String[] cur2 = sc.nextLine().split(" ");
            later[i][0] = Integer.valueOf(cur2[0]);
            later[i][1] = Integer.valueOf(cur2[1]);
        }
        if(T == 0){
            System.out.println(0);
            return;
        }
        Arrays.sort(lunch,(n1,n2)->n2[1] - n1[1]);
        Arrays.sort(later,(n1,n2)->n2[1] - n1[1]);
        //只吃中餐
        int ans1 = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if(lunch[i][1] < T)
                break;
            if(lunch[i][1] >= T) {
                if(lunch[i][0] < ans1){
                    ans1 = lunch[i][0];
                }
            }
        }
        //只吃晚餐
        for (int i = 0; i < M; i++) {
            if(later[i][1] < T)
                break;
            if(later[i][1] >= T) {
                if(later[i][0] < ans1){
                    ans1 = later[i][0];
                }
            }
        }
        //一顿中餐一顿晚餐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lunch[i][1] + later[j][1] < T){
                    break;
                }
                if(lunch[i][1] + later[j][1] >= T){
                    if(lunch[i][0] + later[j][0] < ans1) {
                        ans1 = lunch[i][0] + later[j][0];
                    }
                }
            }
        }
        int ans = ans1 == Integer.MAX_VALUE ? -1 : ans1;
        System.out.println(ans);

    }
}
