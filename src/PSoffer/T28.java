package PSoffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author 李聪
 * @date 2019/12/23 11:00
 */
public class T28 {
    public static void main(String[] args) {
        T28 test = new T28();
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = test.GetLeastNumbers_Solution_Partition(array, 4);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution_Partition(int[] input, int k) {
        //建大顶堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        ArrayList<Integer> list = new ArrayList<>();
        //当k比input还要大时
        if(k == 0 || k > input.length)
            return list;
        for (int i : input) {
            q.add(i);
            if(q.size() > k) {
                q.poll();
            }
        }
        for (Integer i : q) {
            list.add(i);
        }
        return list;
    }
}
