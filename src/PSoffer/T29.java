package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/23 11:18
 */
public class T29 {
    public static void main(String[] args) {

    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if(curSum < 0) {
                curSum = i;
            }else {
                curSum += i;
            }
            max = curSum > max ? curSum : max;
        }
        return max;
    }
}
