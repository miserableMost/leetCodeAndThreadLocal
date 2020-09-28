package 依图;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/17 18:40
 */
public class Main2 {
    private static int a,b,c,d;
    private static int min = -1;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String[] s2 = sc.nextLine().split(" ");
            int x = Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);
            String[] s3 = sc.nextLine().split(" ");
            a = Integer.parseInt(s3[0]);
            b = Integer.parseInt(s3[1]);
            c = Integer.parseInt(s3[2]);
            d = Integer.parseInt(s3[3]);
            char[][] ans = new char[n][m];
            for (int j = 0; j < n; j++) {
                ans[j] = sc.nextLine().toCharArray();
            }
            boolean[][] vistied = new boolean[n][m];
            dfs(ans, 0, 0, x, y, vistied, 0);
            if(min > 0){
                System.out.println("Case #1: " + min);
            }else {
                System.out.println("Case #2: "+ min);
            }

        }


    }

    private static void dfs(char[][] ans, int i, int j, int x, int y, boolean[][] vistied,int value) {
        if(i == x && j == y){
            if(min < value){
                min = value;
                return;
            }
        }
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if(ni < 0 || nj < 0 || ni >= ans.length || nj >= ans[0].length){
                continue;
            }
            if(ans[ni][nj] == 'o' && !vistied[i][j]){
                vistied[i][j] = true;
                if(k == 0){
                    value += a;
                }else if(k == 1){
                    value += b;
                }else if(k == 2){
                    value += c;
                }else {
                    value += d;
                }
                dfs(ans,ni,nj,x,y,vistied,value);
                vistied[i][j] = false;
            }


        }
    }
}
