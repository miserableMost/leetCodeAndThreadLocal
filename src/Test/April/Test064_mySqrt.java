package Test.April;

/**leetCode 69.x的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Test064_mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }

    //采用二分法
    public static int mySqrt(int x) {
        if(x <= 1)
            return x;
        int start = 0;
        int end = x / 2 + 1;
        while (start <= end){
            //注意溢出
            int mid = start + (end - start) / 2;
            long  sqrt = mid * mid;
            if(sqrt == x)
                return (int) mid;
            if(sqrt > x)
                end = (int) (mid-1);
            if(sqrt < x)
                start = (int) (mid +1);
        }
        return end;
    }
}
