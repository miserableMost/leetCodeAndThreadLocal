package Test.June;

/**
 * Test896 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，
 * 那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 1 <= A.length <= 50000
 */
public class Test896_isMonotonic {
    public static void main(String[] args) {
          int [] a = {1,2,2,3};
          System.out.println(isMonotonic(a));

    }


    public static boolean isMonotonic(int[] A) {
        int length = A.length;
        if(length < 3)
            return true;
        boolean flag1 = false,flag2 = false;  //flag1为递增，flag2为递减
        for (int i = 0; i < length-1; i++) {

            if(A[i] > A[i+1]){
               //此时检测是否为递减
                if(flag1) return false;
                flag2 = true;


            }else if(A[i] < A[i+1]){
                //此时检验是否为递增
               if(flag2) return false;
               flag1 = true;
            }
        }
        return true;
    }
}
