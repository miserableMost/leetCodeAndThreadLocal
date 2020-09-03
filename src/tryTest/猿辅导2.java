package tryTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/26 10:20
 */
public class 猿辅导2 {
    private static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    //private static boolean[][] visited;
    private static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //visited = new boolean[N][M];

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = Math.max(res,dfs(arr,i,j,K));
            }
        }
        System.out.println(res);
    }
    public static int dfs(int[][] arr,int i,int j,int k) {
        if(map.containsKey(i + "," + j + "," + k)){
            return map.get(i + "," + j + "," + k);
        }
        int ans = 1;
        for (int l = 0; l < 4; l++) {
            int ni = i + dir[l][0];
            int nj = j + dir[l][1];
            if(ni >= 0 && ni< arr.length && nj >= 0 && nj < arr[0].length) {
                if(arr[i][j] < arr[ni][nj]){
                    ans  = Math.max(ans,dfs(arr,ni,nj,k) + 1);
                }else {
                    if(k > 0){
                        ans  = Math.max(ans,dfs(arr,ni,nj,k - 1) + 1);
                    }
                }
            }
        }
        map.put(i + "," + j + "," + k,ans);
        return ans;

    }
}
