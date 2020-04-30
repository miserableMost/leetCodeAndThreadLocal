package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/3 21:19
 * 有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。  
 */
public class T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[][] arr = new long[t][4];
        for (int i = 0;i < t;i ++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i < t;i++) {
            long[] curArr = arr[i];
            //第一种情况
            //分为四种情况---设球队1得m分
            //1.球队1 > 球队2 >球队3
            //球队1：m
            //球队2：m - d1;
            //球队3：m - d1 - d2;
            //need: d1 + d1 + d2;
            long temp = 0;
            long ans = 0;
            long n = curArr[0],k = curArr[1],d1 = curArr[2],d2 = curArr[3];
            temp = k + (d1 + d1 + d2);
            if(temp >= 0 && temp % 3 == 0) {   //球队1得分有解是大前提
                ans = (n - k) - (d1 + d1 + d2);
                if(ans >=0 && ans % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            //第二种情况
            //2.球队1 < 球队2 < 球队3
            //球队1：m
            //球队2：m + d1；
            //球队3：m + d1 + d2;
            //need : d1 + d2 + d2;
            temp = k - (d1 + d1 +d2);
            if(temp >= 0 && temp % 3 == 0) {   //球队1得分有解是大前提
                ans = (n - k) - (d1 +d2 +d2);
                if(ans >=0 && ans % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            //第三种情况
            //3.球队1 > 球队2 ，球队2 < 球队3
            //球队1：m
            //球队2：m - d1;
            //球队3：m - d1 + d2;
            //当d1 > d2 ;最大为1，need:d1 + (d1 - d2)
            //当d1 <= d2;最大为3，need：d2 + (d2 - d1)
            temp = k + d1 + d1 -d2;
            if(temp >= 0 && temp % 3 == 0) {
                if(d1 >=d2) {
                    ans = (n - k) - (d1 + d1 -d2);
                }else {
                    ans = (n - k) - (d2 + d2 - d1);
                }
                if(ans >=0 && ans % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            //第四种情况
            //4.球队1 < 球队2，球队2 > 球队3
            //球队1：m
            //球队2：m + d1;
            //球队3：m + d1 - d2;
            //need: d1 + d2;

            temp = k - d1 - d1 + d2;
            if(temp >= 0 && temp % 3 == 0) {
                ans = (n - k) - (d1 + d2);
                if(ans >=0 && ans % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            System.out.println("no");
            //分为四种情况---设球队1得m分
            //1.球队1 > 球队2 >球队3
            //球队1：m
            //球队2：m - d1;
            //球队3：m - d1 - d2;
            //need: d1 + d1 + d2;

            //2.球队1 < 球队2 < 球队3
            //球队1：m
            //球队2：m + d1；
            //球队3：m + d1 + d2;
            //need : d1 + d1 + d2;

            //3.球队1 > 球队2 ，球队2 < 球队3
            //球队1：m
            //球队2：m - d1;
            //球队3：m - d1 + d2;
            //当d1 > d2 ;最大为1，need:d1 + (d1 - d2)
            //当d1 <= d2;最大为3，need：d2 + (d2 - d1)

            //4.球队1 < 球队2，球队2 > 球队3
            //球队1：m
            //球队2：m + d1;
            //球队3：m + d1 - d2;
            //need: d1 + d2;

        }
    }
}
