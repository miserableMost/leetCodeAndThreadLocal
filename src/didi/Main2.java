package didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 李聪
 * @date 2020/9/13 18:37
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            //m条数据，每次3个数据
            Set<Integer> map = new HashSet<>();
            for (int j = 0; j < m; j++) {

                int first = sc.nextInt();
                int second = sc.nextInt();
                int cost = sc.nextInt();
                if(cost > k || first > n || second > n){
                    continue;
                }
                map.add(first);
                map.add(second);

            }
            if(map.size() == n){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }

    }
}
