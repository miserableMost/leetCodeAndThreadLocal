package Test.Medium;

/**
 * leetCode : 全局倒置与局部倒置
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
 *
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true
 *
 */
public class T775_isIdealPermutation_8_16 {
    public static void main(String[] args) {
        int[] A = {1,2,0};
        boolean b = isIdealPermutation(A);
        System.out.println(b);
    }
    //局部倒置一定是全局倒置，而全局倒置不一定是局部倒置，这是解这道题的关键点
    //如果我们发现乱序数组中某个数字和其坐标差的绝对值大于1的话，
    // 那么一定是有非局部倒置的全局倒置的存在。猛然这么一说，
    // 可能你会问为啥啊？因为0到n-1中每个数字都是在数组中存在的，
    // 如果当前数字 A[i] 比起坐标 i 大1的话，比如 A[i] = 3, i = 1 的时候
    // ，那么数组的第二个数字是3了，前三个数字suppose是 0，1，2 的，
    // 但是由于第二个数字是3了，那么一定会有一个小于3的数字被挤出前三个数字，
    // 这个小于3的数字最多出现在下标为3的位置上，
    // 那么由于数字3出现在了下标为1的位置上，
    // 所以non-local的全局倒置就出现了。同理，如果当前数字 A[i] 比其坐标 i 小1的话，比如 A[i] = 1, i = 3 的时候，那么就是后 n-i 个数字中有一个大于 A[i] 的数字被挤到了前面去了，
    public static boolean isIdealPermutation(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if(Math.abs(A[i] - i) > 1){
                return false;
            }
        }
        return true;

    }
}
