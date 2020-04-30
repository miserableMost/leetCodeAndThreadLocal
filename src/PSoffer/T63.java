package PSoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/30 21:50
 */
public class T63 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        T63 test = new T63();
        ArrayList<Integer> list = test.maxInWindows(arr, 3);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0)
            return ans;
        //定义一个双端队列,记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //单调栈
            while(!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if(qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表加入元素
            if(i >= size - 1) {
                ans.add(num[qmax.peekFirst()]);
            }
        }
        return ans;
    }
}
