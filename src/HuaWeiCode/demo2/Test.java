package HuaWeiCode.demo2;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/2 16:42
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        List<Integer> t1 =  Arrays.asList(1, 2, 4);

        List<Integer> t2 =  Arrays.asList(1, 3, 4);
        List<Integer> t3 =  Arrays.asList(4, 6, 7);
        List<Integer> t4 =  Arrays.asList(1, 2, 5,4);
        ArrayList<Integer> l1 = new ArrayList<>(t1);
        ArrayList<Integer> l2 = new ArrayList<>(t2);
        ArrayList<Integer> l3 = new ArrayList<>(t3);
        ArrayList<Integer> l4 = new ArrayList<>(t4);
        list.add(l2);
        list.add(l1);
        list.add(l4);
        list.add(l3);
        sortByDic(list);
        for (ArrayList<Integer> arrayList : list) {
            for (Integer i : arrayList) {
                System.out.print(i + "    ");
            }
            System.out.println();
        }

    }
    private static void sortByDic(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() == o2.size()) {
                    int i = 0;
                    while(i <= o1.size() && o1.get(i) == o2.get(i)) {
                        i ++;
                    }
                    if(i > o1.size()) {
                        return 0;
                    }else {
                       return o1.get(i) - o2.get(i);
                    }
                }else {
                    return o1.size() - o2.size();
                }

            }
        });

    }
}
