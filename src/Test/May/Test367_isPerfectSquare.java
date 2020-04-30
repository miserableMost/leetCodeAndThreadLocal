package Test.May;

/**leetCode 367:完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class Test367_isPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }


    //二分法超时
/*    public static boolean isPerfectSquare(int num) {
        boolean isPs = false;
        if (num <= 1)
            return true;
        int start = 0;
        int end = num/2 + 1 ;
        while(start <= end){
            int mid = (start + end)/2;
            long sqrt = mid * mid;
            if(num == sqrt) {
                isPs = true;
                break;
            }else{
                if(num > sqrt)
                    start = mid + 1;
                if(num < sqrt)
                    end = mid - 1;
            }
        }
        return isPs;
    }*/
    public static boolean isPerfectSquare(int num){
        //利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
        int sum = 1;
        while(num > 0){
            num -= sum;
            sum += 2;
        }
        return num == 0;

    }

}
