package Test.July;

/**
 * leetCode 204:计算质数
 * 统计所有小于非负整数 n 的质数的数量
 */
public class Test204_countPrimes_7_23_REMEMBER {
    public static void main(String[] args) {
         countPrimes(10);
    }
    //厄拉多塞筛法
    //具体操作：先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈，然后划去2的其他倍数；
    // 第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；现在既未画圈又没有被划去的第一个数 是5，
    // 将它画圈，并划去5的其他倍数……依次类推，一直到所有小于或等于 n 的各数都画了圈或划去为止。
    // 这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数。

    public static int countPrimes(int n) {
        int count = 0;
        //定义一个数组
        boolean []flagArray = new boolean[n];
        //0、1必然为false
        for (int i=2; i<n; i++){
            flagArray[i] = true;
        }

        for (int i=2; i<n; i++){
            //如果此位是一个素数
            if (flagArray[i]){
                for (int k=2; k*i<n; k++){
                    flagArray[k*i] = false;
                    count ++;
                }
            }
        }
        //统计数组中为true的个数
        int result = 0;
        for (int i=2; i<n; i++){
            if (flagArray[i]){
                result++;
            }
        }

        return result;
    }
}
