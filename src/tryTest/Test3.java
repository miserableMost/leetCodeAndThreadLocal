package tryTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/23 23:10
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        /*for (int i = 0; i < N * M; i++) {
            arr[i/N][i % M] = sc.nextInt();
        }*/
        int[][] visited = new int[N][M];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int r = 0,c = 0, d = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N * M; i++) {
            ans.add(arr[r][c]);
            visited[r][c] = 1;
            int ni = r + dir[d][0];
            int nj = c + dir[d][1];
            if(ni >= 0 && ni < N && nj>= 0 && nj < M && visited[ni][nj] == 0) {
                r = ni;
                c = nj;

            }else {
                d = (d + 1) % 4;
                r += dir[d][0];
                c += dir[d][1];
            }

        }
        for (int i = 0;i < ans.size();i ++) {
            if(i != ans.size() - 1){
                System.out.print(ans.get(i) + " ");
            }else {
                System.out.println(ans.get(i));
            }
        }
    }
}
