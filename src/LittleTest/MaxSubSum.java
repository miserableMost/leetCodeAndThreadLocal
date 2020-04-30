package LittleTest;
/**
 *                       3  -2  5  -3  4  7  -6  9                         0
 *      ----------------------------------------------------------------------------
 *             3  -2  5  3                      4  7  -6  9                1
 *      ----------------------------------------------------------------------------
 *         3  -2         5  -3                                             2
 *      ----------------------------------------------------------------------------
 *      3      -2                                                          3
 *      ----------------------------------------------------------------------------
 *                   5       -3                                            4
 *      ----------------------------------------------------------------------------
 *                                          4  7         -6  9             5
 *      ----------------------------------------------------------------------------
 *                                       4      7                          6
 *      ----------------------------------------------------------------------------
 *                                                    -6       9           7
 *      ----------------------------------------------------------------------------
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int[] a = {3,-2,5,-3,4,7,-6,9};
        System.out.println(maxSumRec(a,0,a.length-1));
    }


    //如果全部传入负数，不得行
    public static int maxSumRec(int[] a,int left,int right){
        if(left == right){
            if(a[left] > 0){
                return a[left];
            }else{
                return 0;
            }
        }
        int center = (left + right)/2;
        int maxLeftSum = maxSumRec(a,left,center);
        System.out.print("maxLeftSum:"+maxLeftSum+"    ");
        int m = right;
        int maxRightSum = maxSumRec(a,center+1,right);
        System.out.print("maxRightSum:"+maxRightSum+"    ");
        int maxLeftBorderSum = 0,leftBorderSum = 0;
        for (int i = center; i >=left ; i--) {
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }
        int maxRightBorderSum = 0,rightBorderSum = 0;
        for (int i = center+1; i <= right ; i++) {
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        int between = maxLeftBorderSum+maxRightBorderSum;
        System.out.print("横跨中间的："+between+"    ");
        int max3 =  max3(maxLeftSum,maxRightSum,between);
        System.out.print("最大的："+max3+"    ");
        System.out.println("下一轮");
        return max3;

    }

    public static int max3(int a,int b,int c){
        if (a > b&&a > c){
            return a;
        }
        if (b > a&&b > c){
            return b;
        }
        return c;
    }
}
