package Test.August;

import java.util.Arrays;

/**
 * leetCode 821 : 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 */
public class D14_shortestToChar_821 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] res = shortestToChar(s, c);
        System.out.println(Arrays.toString(res));
    }
    public static int[] shortestToChar(String S, char C) {
        /*int len = S.length();
        int[] res = new int[len];
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char p = S.charAt(i);
            if(p == C){
                count.add(i);
                res[i] = 0;
            }
        }

        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            char p = S.charAt(i);
            if(p != C){
                for (Integer j : count) {
                     min =  Math.min(Math.abs(i - j),min);
                }
                res[i] = min;
            }
        }
        return res;*/

        int len = S.length();
        int[] res = new int[len];
        //记录前两个出现的位置
        int left = S.indexOf(C),right = S.indexOf(C,left + 1);
        for (int i = 0; i < len; i++) {
            res[i] = Math.abs(left - i);
            if(right != -1){
                //右指针存在
                res[i] = Math.min(res[i],right - i);
                //走到右指针则左右指针往下一个
                if(i == right){
                    res[i] = 0;
                    left = right;
                    right = S.indexOf(C,right + 1);
                }
            }
        }
        return res;
    }
}
