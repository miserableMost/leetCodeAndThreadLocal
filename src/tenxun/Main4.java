package tenxun;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/23 19:17
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder();
       // LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            if(i == k - 1)
                continue;
            sb.append(m);
            if(i != n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
