package Test.April;

/**
 * leetCode:3的幂 ,4的幂同样
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class Test326_Test342_isPowerOfThree {
    public static void main(String[] args) {
        boolean isThree = isPowerOfThree(64);
        System.out.println(isThree);
    }



    public static boolean isPowerOfThree(int n) {
        //递归
           /*if(n == 0)
               return false;
           if(n == 1)
               return true;
           if(n%3 != 0)
               return false;

          return isPowerOfThree(n/3);*/
         //循环
        /*if(n <= 0 || n ==2)
            return false;
        if(n == 1)
            return true;
        while(n > 1){
            if(n%3 != 0)
                return false;
            n /= 3;
        }
        return true;*/
        //对数的方法：一个数是3的次方，那么以3为底n的对数一定是个 整数。
        //根据公式LOGaB = LOGcB /LOGcA;
        double m = Math.log10(n) / Math.log10(4);
        //判断dpuble是否是整数
        return (m - (int)(m)) == 0 ? true : false;
    }
}