package Test.July;

import java.util.Arrays;

/**
 * leetCode 942:增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 *     如果 S[i] == "I"，那么 A[i] < A[i+1]
 *     如果 S[i] == "D"，那么 A[i] > A[i+1]
 */
public class Test942_diStringMatch_7_24 {
    public static void main(String[] args) {
        int[] res = diStringMatch("DDI");
        System.out.println(Arrays.toString(res));
    }
    public static int[] diStringMatch(String S) {
        int length = S.length();
        int[] res = new int[length + 1];
        int little = 0;
        int big = length;
        for (int i = 0; i < length; i++) {
            if(S.charAt(i) == 'I' ){
                res[i] = little;
                little ++ ;
            }
            if(S.charAt(i) == 'D'){
                res[i] = big;
                big --;
            }

        }
        if(S.charAt(length - 1) == 'D')
                res[length] = big;
            else
                res[length] = little;

        return res;


    }
}
