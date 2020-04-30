package medium;

import java.util.List;

/**
 * leetCode 120 : 三角形最小路径和
 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 */
public class T120_minimumTotal_9_8 {
    public static void main(String[] args) {

    }
    //自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        // minlen中记录了求第i行时，第i+1的最小路径和
        int[] minlen = new int [level + 1];
        for (int i =  level - 1; i >= 0 ; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size() ; j++) {    //每一行 j+1个数
                minlen[j] = Math.min(minlen[j],minlen[j + 1]) + rows.get(i);
            }
        }
        return minlen[0];
    }
}
