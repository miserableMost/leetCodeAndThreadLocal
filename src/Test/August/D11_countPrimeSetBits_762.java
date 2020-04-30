package Test.August;

/**
 * leetCode 762 : 二进制表示中质数个计算置位
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 */
public class D11_countPrimeSetBits_762 {
    public static void main(String[] args) {
        D11_countPrimeSetBits_762 t1 = new D11_countPrimeSetBits_762();
        boolean prime = t1.isPrime(4);
        int i = t1.countPrimeSetBits(842, 888);
        System.out.println(i);
    }
    public int countPrimeSetBits(int L, int R) {
        //总的质数个数
        int ans = 0;
        for (int i = L; i <= R; i++) {
            int count = 0; //用于计算1的个数
            int num = 0;
           /* String s = Integer.toBinaryString(i);
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1')
                    count ++;
            }*/
           int val = i;
           while(val != 0){

               if((val & 1) != 0)
                   num ++;
               val >>>= 1;
           }
            //判断count是否为质数--直接使用枚举
            if(num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 || num == 17 || num == 19)
                ans ++;


            /*if(isPrime(count)){
                ans ++;
            }*/
        }
        return ans;
    }
    //判断一个数是否是质数
    public boolean isPrime(int n){
        if(n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
