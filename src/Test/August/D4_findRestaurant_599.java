package Test.August;

import java.util.*;

/**
 * leetCode 599:两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 */
public class D4_findRestaurant_599 {
    public static void main(String[] args) {
         String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
         String[] s2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(s1,s2)));
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        /*for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if(list1[i].equals(list2[j])){
                    int sum = i + j;
                    if(sum < minIndex){
                        res.clear();
                        minIndex = sum;
                        res.add(list1[i]);
                    }else if(sum == minIndex)
                        res.add(list1[i]);

                }
            }
        }*/
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                if(map.get(list2[i]) + i < minIndex){
                    res.clear();
                    minIndex = map.get(list2[i]) + i;
                    res.add(list2[i]);
                }else if(map.get(list2[i]) + i == minIndex)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
