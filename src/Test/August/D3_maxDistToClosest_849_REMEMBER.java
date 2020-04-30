package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 849:到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。

 */
public class D3_maxDistToClosest_849_REMEMBER {
    public static void main(String[] args) {
         int[] seats = {1,0,0,0};
        int i = maxDistToClosest(seats);
        System.out.println(i);
    }

    /**
     * 我们将有人的座位的下标记录到一个list中，剩下的事情就是要找一个点，距离list中某个元素的最大距离
     *
     * 以示例1为例，我们构造了一个list，为[0,4,6]，那么你想找的那个点的下标一定是在0-4和4-6之间，所以只需要求出他们之间的中点距离即可。 以示例2为例，我们构造了一个list，为[0]，那么你想找的那个店的下标一定在0-seats.length之间，依次比较即可。
     *
     * 所以我们可以将此题抽象出来，假设有一个seats数组，为[a0,a1,a2.....an]，其中有人的为i，j，k，那么我们要找的点就一定在0-i,i-j,j-k和k-seats.length之间，依次比较即可。
     * @param seats
     * @return
     */
    public static int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            //把有座位的人的位置统计出来
            if(seats[i] == 1)
               list.add(i);
        }
        //计算两头之间的距离
        int start = list.get(0);
        int end = seats.length - list.get(list.size() - 1) - 1;
        int maxL = Math.max(start,end);
        //计算中间的
        for (int i = 1; i < list.size(); i++) {
            //计算两个人之间的距离，最小距离的最大值便是(list.get(i) - list.get(i - 1)) / 2
            int temp = (list.get(i) - list.get(i - 1)) / 2;
            if(temp > maxL)
                maxL = temp;
        }
        return maxL;
    }
}
