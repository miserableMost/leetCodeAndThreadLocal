package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 989:数组形式的整数加法
 *对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234

 */
public class Test989_addToArrayForm {

    public static void main(String[] args) {
        int[] A = {9,9};
        int k = 1;
        List<Integer> list = addToArrayForm(A, k);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {

        //返回结果的集合
        List<Integer> res = new ArrayList<>();
        String s = K + "";
        int carry = 0;
        for (int i = A.length - 1,j = s.length() - 1; i >= 0 || j >= 0; i--,j--) {
            //显示每一位相加的结果
            int num = carry;
            num += i >= 0 ? A[i] : 0;
            num += j >= 0 ? s.charAt(j) - '0' : 0;
            //每次加在最前面
            res.add(0,num % 10);
            carry = num / 10;
        }
        //检查最后
        if(carry > 0){
            res.add(0,carry);
        }
        return res;
    }
}
