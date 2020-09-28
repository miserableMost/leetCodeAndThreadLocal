package sougou;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/9/5 18:00
 */
public class Main2 {
    public static void main(String[] args) {
        Main2 m2 = new Main2();
        int[] arr = {-1,4,5,2};
        System.out.println(m2.getHouses(2, arr));

    }
    public int getHouses (int t, int[] xa) {
        // write code here
        if(xa == null || xa.length == 0)
            return 0;
        int n = xa.length;
        double[][] ans = new double[n / 2][2];
        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            double left = xa[i] - xa[i + 1] * 0.5;
            double right = xa[i] + xa[i + 1] * 0.5;
            ans[idx] = new double[]{left,right};
            idx ++;
        }
        Arrays.sort(ans,(n1,n2) -> (int) (n1[0] - n2[0]));
        if(ans.length == 1)
            return 1;
        int res = 2;
        for (int i = 1; i < ans.length; i++) {
            if(ans[i][0] - ans[i - 1][1] == t){
                res ++;
            }else if(ans[i][0] - ans[i - 1][1] > t){
                res += 2;
            }
        }
        return res;
    }
}
