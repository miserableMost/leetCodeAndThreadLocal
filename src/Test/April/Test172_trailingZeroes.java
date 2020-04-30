package Test.April;

/**leetCode :172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 */
public class Test172_trailingZeroes {
    public static void main(String[] args) {

        System.out.println(trailingZeroes(10000));

    }
     //给定一个整数N，求它的阶乘后面有几个0，将一般有零整数拆分之后，
     // 其0产生的原因必然是因为2*5导致的，而且2的数量必然大于等于5的数量(5为奇数，若2不去抵消5，必然不构成0)。
     //
     //由上述问题可知，对于一个整数N，其在1~N中，能够被5整除的数有m个，则必然有m个0,
     // 但是对于25这种由5*5构成的则少加了一个0，为了补全，需要在1~N/5中再次寻找能够被5整除的，依次循环下去。
     public static int trailingZeroes(int n){
        int sum = 0;
        while(n != 0){
            n /= 5;
            sum += n;
        }
        return sum;
     }


    /*public static  int trailingZeroes(int n) {
        if(n==0)
            return 1;
         long s = recursion(n);
         int count = 0;
         String str = s + "";
         for(int i=str.length()-1;i>=0;i--){
             if(str.charAt(i) == '0'){
                 count ++ ;
             }else if(str.charAt(i) != '0'){
                 break;
             }
         }

         return count;
    }


    //递归计算阶乘
    public static long recursion(int n){
        long sum = 1;
        if(n<0)
            throw new RuntimeException("没得玩");
        if(n == 1) {
            return 1;
        }else{
            sum = n * recursion(n-1);
            return sum;
        }

    }*/
}
