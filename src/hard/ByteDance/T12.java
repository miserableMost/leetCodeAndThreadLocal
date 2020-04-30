package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/4 21:48
 *
 * 机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号，从左到右排列。编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位。
 *
 * 起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。
 *
 * 它将会得到或者失去正比于与H(k+1)与E之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。
 *
 * 游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？
 */
public class T12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = sc.nextInt();
        }
        int E = 0; //假设最会一步的能量为0
        for(int i = N - 1;i >= 0;i --) {
            E = (int) Math.ceil((E + H[i])/2);
        }
        System.out.println(E);
    }
}
