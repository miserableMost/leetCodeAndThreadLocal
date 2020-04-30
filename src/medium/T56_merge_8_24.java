package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetCode 56:合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class T56_merge_8_24 {
    public static void main(String[] args) {
        int[][] nums = {{1,3},{8,10},{15,18}};
        int[][] merge = merge(nums);
        for (int[] ints : merge) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals == null ||intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        //先加入第一个数组
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] >= intervals[i][0]){
                //需要进行合并--将前一个删除
                ans.remove(ans.size() - 1);
                //将区间合并，可能出现1-4,2-3的情况
                intervals[i] = new int[] {intervals[i - 1][0],Math.max(intervals[i - 1][1],intervals[i][1])};
            }
            ans.add(intervals[i]);
        }

        int[][] res = new int[ans.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }
        return res;
    }
}
