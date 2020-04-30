package Test.July;

import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 575: 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果、
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 *
 */
public class Test575_distributeCandies_25 {
    public static void main(String[] args) {
         int[] candies = {1,1,2,3};
        int res = distributeCandies(candies);
        System.out.println(res);
    }
    public static int distributeCandies(int[] candies) {
         int length = candies.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(candies[i]);
        }
        //如果不同的糖果超过一半。则返回数组长度的一半
        if(set.size() >= length / 2)
            return length / 2;
        //否则返回set的大小
        else
            return set.size();


    }
}
