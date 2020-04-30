package hard.ByteDance;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/5 19:57
 */
public class T16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //记录手珠的个数
        int m = sc.nextInt();   //记录连续m个串珠
        int c = sc.nextInt();   //记录手串上的颜色一共多少种
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); //记录每个颜色出现在哪几个手串中
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                int color = sc.nextInt();
                if(map.containsKey(color)) {
                    ArrayList<Integer> cur = map.get(color);
                    cur.add(i);
                    map.put(color,cur);
                }else {
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    map.put(color,cur);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= c; i++) {
            ArrayList<Integer> temp = map.get(i);
            //题目大意是不用排序的，因为珠子是顺序出的
            Collections.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if(n - (temp.get(temp.size() - 1) + temp.get(0)) < m) {
                count ++;
            } else {
                for (int j = 1; j < temp.size(); j++) {
                    if(temp.get(j) - temp.get(j - 1) < m){
                        count ++;
                        break;
                    }

                }
            }
        }
        System.out.println(count);





    }
}
