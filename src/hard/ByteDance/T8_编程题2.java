package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/4 18:34
 *  有n个房间，现在i号房间里的人需要被重新分配，分配的规则是这样的：先让i号房间里的人全都出来，接下来按照 i+1, i+2, i+3, ... 的顺序依此往这些房间里放一个人，n号房间的的下一个房间是1号房间，直到所有的人都被重新分配。
 *
 * 现在告诉你分配完后每个房间的人数以及最后一个人被分配的房间号x，你需要求出分配前每个房间的人数。数据保证一定有解，若有多解输出任意一个解。
 */
public class T8_编程题2 {

    // 思路：分配后的房间里，人数最少的那一个房间就是i号房间。如果有多个房间人数最少，则取x号房间往前数的第一个人最少的房间。
    // 综上：无论哪种情况，从x房间往前数找到的第一个人最少的房间就是i号房间。
    // 找出i号房间后，就很容易求出之前的人数了。首先根据i号房间最后的人数确定完整的轮数，然后从x号往前再减去最后不足一轮的部分，然后把多出的人数全部补到第i个房间，就结束了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt() - 1;
        int[] room = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextInt();
            if(room[i] < min)
                min = room[i];
        }
        int minIndex = x;
        while(room[minIndex] != min) {
            minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
        }
        //去掉轮数
        for (int i = 0; i < n; i++) {
            room[i] -= min;
        }

        int remain = 0;
        //天秀
        for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
            room[i] -= 1;
            remain += 1;
        }
        room[minIndex] += remain + n * min;
        for (int i = 0; i < n; i++) {
            System.out.print(room[i] + " ");
        }
    }
}
