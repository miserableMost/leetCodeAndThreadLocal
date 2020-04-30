package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/3/30 17:10
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0;i < n;i ++) {
            num[i] = sc.nextInt();
        }

        //之所以设置为0，保证上端全为正数，下端全为负数
        long max1=0,max2=0,max3=0, min1=0,min2=0;
        for (int i = 0; i <n ; i++) {
            if(num[i]!=0){
                if(num[i]>max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = num[i];
                }else if(num[i]>max2){
                    max3 = max2;
                    max2 = num[i];
                }else if(num[i]>max3){
                    max3 = num[i];
                }else if(num[i]<min1 ){
                    min2 = min1;
                    min1 = num[i];
                }else if(num[i]>min1 && num[i]<min2){
                    min2 = num[i];
                }
            }else continue;

        }

        long ans = 0;
        ans = Math.max(max1 * max2 * max3,max1 * min1 * min2);
        System.out.println(ans);
    }
}
