package Test.July;

import java.util.Arrays;

/**
 * leetCode 888: 公平的糖果交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，
 * B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，
 * 这样交换后，他们都有相同的糖果总量。
 * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
 * ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。

 */
public class Test888_fairCandySwap_25 {

    public static void main(String[] args) {
        int[] A = {1,2,5};
        int[] B = {2,4};
        int[] m = fairCandySwap(A, B);
        System.out.println(Arrays.toString(m));
    }
    public static int[] fairCandySwap(int[] A, int[] B) {
        /*int[] res = new int[2];
        int sumA = 0,sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int sub = sumA - sumB;  //不要用绝对值
         for (int i = 0; i < A.length; i++) {
             int num1 = A[i];
             int num2 = num1 - sub / 2;
             for (int j = 0; j < B.length; j++) {
                 if(B[j] == num2){
                     res[0] = num1;
                     res[1] = num2;
                 }
             }
        }
        return res;*/
        int[] ans = new int[2];
        int sumA = 0, sumB = 0;
        for(int i: A){
            sumA += i;
        }
        for(int j: B){
            sumB += j;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int temp = sumA-(sumA+sumB)/2;  //(sumA+sumB)/2为应该达到的值。无须考虑绝对值
        int i = 0, j = 0;
        while(i<A.length&&j<B.length){
            if(A[i]-B[j]==temp){
                ans[0] = A[i];
                ans[1] = B[j];
                break;
            }
            else if(A[i]-B[j]>temp){
                j++;
            }
            else if(A[i]-B[j]<temp){
                i++;
            }
        }
        return ans;
    }
}
