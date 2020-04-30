package Test.April.utils;

import java.util.ArrayList;
import java.util.List;

public class Test138_generate {
    public static void main(String[] args) {
        List<List<Integer>> re = generate(6);
        for (List<Integer> se : re) {
            for (Integer x : se) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
         List<List<Integer>> result = new ArrayList<>();
         for (int i = 0; i < numRows; i++) {
             //表示每一行的添加，每一次list需要重新开始
             List<Integer> list = new ArrayList<>();
             for(int j = 0;j <= i;j++){
                 //第一行、每一行第一个、每一行最后一个都为1
                 if(i==0 || j == 0 || j == i){
                     list.add(1);
                 }else{
                     //每一行其他的等于上一行的两个相加
                     Integer mine = result.get(i-1).get(j-1)+ result.get(i-1).get(j);
                     list.add(mine);
                 }
             }
             result.add(list);
             /*for (List<Integer> se : result) {
                 for (Integer x : se) {
                     System.out.print(x);
                 }
                 System.out.println();
             }*/
        }
         return result;
    }
}
