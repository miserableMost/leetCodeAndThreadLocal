package hard.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/5 19:11
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 */
public class T15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1;i <= n;i ++) {
            int a = sc.nextInt();
            if(map.containsKey(a)) {
                ArrayList<Integer> l = map.get(a);
                l.add(i);
                map.put(a,l);
            }else {
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(i);
                map.put(a,cur);
            }

        }
        int q = sc.nextInt();
        int[][] arrs = new int[q][3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                arrs[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {
            int[] curArr = arrs[i];
            int count = 0;
            int l = curArr[0],r = curArr[1],k = curArr[2];
            if(map.containsKey(k)) {
                for (Integer a : map.get(k)) {
                    if(a >= l && a <= r)
                        count ++;
                }
            }
            System.out.println(count);
        }
    }
}
