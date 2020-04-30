package hard.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/5 16:57
 * 【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 */
public class T14 {
    //dp[i][j]:表示v中第i到第j个位置的字母如果需要移动到在一起，需要移动的次数。
    //两个相邻字母交换
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int m = sc.nextInt();
        int res = 1;
        //记录交换之后每个字母连续出现的个数
        for(char ch = 'a';ch <= 'z';ch ++) {
            //记录每个字母在list中的位置
            ArrayList<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if(ch == s.charAt(i)) {
                    indexs.add(i);
                }
            }
            //没有连续字符的跳过
            if(indexs.size() < 2) {
                continue;
            }
            int size = indexs.size();
            int[][] dp = new int[size][size];
            for (int j = 1; j < size; j++) {
                dp[j - 1][j] = indexs.get(j) - indexs.get(j - 1) - 1;
            }
            //区间从2到size
            for(int length = 2;length < size;length ++) {
                for (int left = 0;left < size - length;left ++) {
                    int right = left + length;
                    //例如
                    //abcdaadegca
                    //对于a来说
                    //indexal中存放的index: 0 5 6 11
                    //遍历0-2，1-3 等区间

                    //对于最左边位置left和最右边位置right字符串，如果只需要将这俩字符移动在一起，则需要固定的(v[right] - v[left] - 1)次移动，
                    // 但是这个区间内已经有了移动好的(right - left - 1)个字母，所以可以少移动这么多次，固需要减去这个数字。
                    dp[left][right] = dp[left + 1][right- 1] + indexs.get(right) - indexs.get(left) - 1 -(right - left -1);
                    //m次操作内可以完成
                    if(dp[left][right] <= m){
                        res = Math.max(res,right - left + 1);
                    }
                }
            }
        }
        System.out.println(res);
    }
}
