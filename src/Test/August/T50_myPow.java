package Test.August;

/**
 * leetCode 50 : 我的指数
 */
public class T50_myPow {
    public static void main(String[] args) {

    }
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            x = 1 / x;
            N = -n;
        }
        return diguiPow(x,N);
    }

    private double diguiPow(double x, long n) {
        if(n == 0){
            return 1;
        }
        double half = diguiPow(x,n / 2); //假设已经知道n/2
        if(n % 2 == 0){
            //n为偶数
            return half * half;
        }else {
            return half * half * x;
        }
    }
}
