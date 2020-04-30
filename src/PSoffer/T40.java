package PSoffer;

import java.util.ArrayList;

/**
 * @author 李聪
 * @date 2019/12/27 19:40
 */
public class T40 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int pleft = 1;
        int pright = 2;
        while(pleft < pright) {
            int cur = (pright - pleft + 1) * (pright - pleft + 2) /2;
            if(cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pleft; i <= pright; i++) {
                    list.add(i);
                }
                res.add(list);
                pleft ++;
            }else if(cur < sum) {
                pright ++;

            }else {
                pleft ++;
            }
        }
        return res;
    }
}
