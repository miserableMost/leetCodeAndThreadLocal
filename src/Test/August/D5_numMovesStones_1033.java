package Test.August;

import java.util.Arrays;

/**
 * leetCode 1033: 移动石子直到连续
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 *
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 *
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 *
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 *
 */
public class D5_numMovesStones_1033 {
    public static void main(String[] args) {
        int[] ints = numMovesStones(1, 2, 5);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] numMovesStones(int a, int b, int c) {
        int[] temp = {a,b,c};
        Arrays.sort(temp);
        int max = temp[2],min = temp[0],mid = temp[1];
        int[] res = new int[2];
        res[1] = max - min - 1 - 1;
        //出现a_b_c情况
        if(max - mid == 2 || mid - min == 2)
            res[0] = 1;
        else
            res[0] = (max - mid == 1 ? 0 : 1) + (mid - min == 1 ? 0 : 1);
        return res;
    }
}
