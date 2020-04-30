package Test.April;

/*
 * 求最大子序列的和
 * 任何负的子序列不可能是最优子序列的前缀，如果在内循环中检测到从a[i]到a[j]的子序列是负的，可以直接推进到a[j+1].
 */
public class MaxSumRec {

    public static void main(String[] args) {
        int [] arr = {1,3,-1,-8,9,8,-7,6,6,-9};
        System.out.println(maxSubSum1(arr));

    }

    private static int maxSubSum1(int [] a) {
        int maxSum = 0;
        int thisSum = 0;
        for(int i=0;i<a.length;i++) {

            thisSum += a[i];
            if(maxSum < thisSum) {
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;

            }

        }
        return maxSum;

    }
}
