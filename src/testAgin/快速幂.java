package testAgin;

/**
 * @author 李聪
 * @date 2020/9/16 19:13
 */
public class 快速幂 {
    int mod = 999999999;
    public static void main(String[] args) {

    }
    public int quickPow(int a,int b) {
        int base = a;
        int res = 1;
        while(b != 0){
            //如果为奇数
            if((b & 1) == 1){
                res = res * base % mod;
            }
            base = base * base % mod;
            b = b >> 1;
        }
        return res % mod;
    }
}
