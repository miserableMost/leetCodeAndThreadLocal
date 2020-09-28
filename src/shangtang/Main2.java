package shangtang;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/18 18:51
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        int n = sc.nextInt();
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double x1 = arr[i][0];
            double y1 = arr[i][1];
            double res = 0;
            for (int j = i + 1; j < n; j++) {
                //两点确定一条直线
                double x2 = arr[j][0];
                double y2 = arr[j][1];
                if(y2 == y1){
                    res = Math.abs(y - y1);
                }else if(x1 == x2){
                    res = Math.abs(x - x1);
                }else {
                    double ty = y2 - y1;
                    double tx = x2 - x1;
                    double A = -1/tx;
                    double B = 1/ty;
                    double C = x1/tx - y1/ty;
                    double v = Math.pow(A, 2) + Math.pow(B, 2);
                    double u = Math.abs(A * x + B * y + C);
                    res = u/(Math.sqrt(v));
                }
                if(res < ans){
                    ans = res;
                }
            }
        }
        System.out.println(String.format("%.3f",ans));

    }
}
