package Test.July;

import java.util.Arrays;

/**
 * leetCode 922:按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案

 */
public class Test922_sortArrayByParityII {

    public static void main(String[] args) {
         int[] arr = {1,3,4,2};
        int[] result = sortArrayByParityII2(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int length = A.length;

        int[] res = new int[length];
        int m = 0;
        int n = 1;
        for (int i = 0; i < length; i++) {
            //如果是偶数
            if(A[i] % 2 == 0){
                res[m] = A[i];
                m += 2;
            }else{
                res[n] = A[i];
                n += 2;
            }

        }
        return res;
    }
   //leetCode别人的
    public static int[] sortArrayByParityII2(int[] A) {
        int n = 1;
        //循环遍历偶数的位置
        for(int i = 0;i < A.length-1;i += 2) {
            //如果为奇数
            while(A[i]%2 != 0){
                //将此偶数位上的奇数与奇数位进行交换，直到此位为偶数
                int c = A[i];
                A[i] = A[n];
                A[n] = c;
                //递增
                n += 2;
                System.out.println("交换");
            }
        }
        return A;
    }
}
