package tenxun;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/23 19:17
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        for (int i = 0; i < arr.length; i++) {
            long cur = arr[i];
            System.out.println(getSum(cur));
        }

    }

    private static long getSum(long a) {
        if(a < 9)
            return a;
        a -= 9;
        long tmp = a % 10;
        return getSum(a / 10) + tmp + 9;
    }
}
