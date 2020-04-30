package Test.July;

import java.util.Arrays;

/**
 * leetCode 475: 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 *     给出的房屋和供暖器的数目是非负数且不会超过 25000。
 *     给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 *     只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 *     所有供暖器都遵循你的半径标准，加热的半径也一样。
 */
public class Test475_findRadius_31 {
    public static void main(String[] args) {
        int[] house = {1,2,3,4};
        int[] heaters = {1,4};
        int i = findRadius(house, heaters);
        System.out.println(i);
    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int hIndex=0;
        int res=0;
        for(int house:houses){
            //此循环用于找到距离最小的供暖器
            while(hIndex<heaters.length-1 && (Math.abs(heaters[hIndex] - house) >= Math.abs(heaters[hIndex+1] - house)))
                hIndex++;
            res=Math.max(res,Math.abs(heaters[hIndex]-house));
        }
        return res;
    }
}
