package PSoffer;

import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/29 9:40
 */
public class T45 {
    public static void main(String[] args) {

    }
    public int LastRemaining_Solution(int n, int m) {
        //用链表来模拟整个过程
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //定义要被剔除的节点
        int bt = 0;
        while(list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
