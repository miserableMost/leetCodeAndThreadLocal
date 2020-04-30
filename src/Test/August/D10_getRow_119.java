package Test.August;
/**
 * leetCode 119:杨辉三角
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */

import java.util.ArrayList;
import java.util.List;

public class D10_getRow_119 {

    public static void main(String[] args) {
        List<Integer> row = getRow(0);
        for (Integer i : row) {
            System.out.print(i+" ");
        }
    }
    public static List<Integer> getRow(int rowIndex) {
        //使用temp记录上一行的
         int[] temp = new int[rowIndex + 1];
         int[] res = new int[rowIndex + 1];
         List<Integer> ans = new ArrayList<>();
         if(rowIndex == 0){
             ans.add(1);
             return ans;
         }
         if(rowIndex == 1){
             ans.add(1);
             ans.add(1);
             return ans;
         }
         temp[0] = 1;
         temp[1] = 1;
         //记录每一行
        for (int i = 2; i <= rowIndex; i++) {
            //每一列
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    res[j] = 1;
                }else{
                    res[j] = temp[j - 1] + temp[j];
                }
            }
            //将这一行变成前一行
            temp = res.clone();
        }
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i]);
        }
        return ans;

    }
}
