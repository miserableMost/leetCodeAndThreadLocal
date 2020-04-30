package Test.August;

/**
 * leetCode 598:范围求和
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 *
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 *
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 *
 */
public class D11_maxCount_598 {
    public static void main(String[] args) {

    }
    //求操作数组所构成的面积中重叠部分的最小值
    public int maxCount(int m, int n, int[][] ops) {
        int maxR = 40000,maxC = 40000;
        //如果ops为空，则全部为0
        if(ops.length == 0)
            return m * n;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0] < maxR)
                maxR = ops[i][0];
            if(ops[i][1] < maxC)
                maxC = ops[i][1];
        }
        return maxC * maxR;
    }
}
