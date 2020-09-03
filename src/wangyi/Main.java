package wangyi;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/8 14:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long cur = arr[i];
            if(cur <= 1)
                continue;
            if(cur == 2 || cur == 3){
                sum ++;
                continue;
            }
            sum += cur / 2;
            //全是2的倍数
            /*if(cur % 2 == 0) {
                sum += cur / 2;
                continue;
            }*/
          /*  //全是3的倍数
            if(cur % 3 == 0){
                sum += cur / 3;
                continue;
            }*/
            //为奇数了
            /*int count = 1;
            int tmp = cur / 2 - 1;
            count += tmp;*/

           /* while(cur > 3) {
                cur -= tmp * 2;
                count ++;
            }
            if(cur == 3) {
                count ++;
            }else {
                count = 0;
            }*/
        }
        System.out.println(sum);
    }

}
