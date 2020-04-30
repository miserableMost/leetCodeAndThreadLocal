package medium;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/7 17:48
 */
public class TestMe {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 21;
        a[2] = 23;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println(b.length);
        for (int i : b) {
            System.out.print(i + " ");
        }
    }
}
