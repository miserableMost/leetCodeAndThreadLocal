package Test.August;

/**
 * leetCode 852 : 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 *     A.length >= 3
 *     存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 */
public class D6_peakIndexInMountainArray_852 {
    public static void main(String[] args) {

    }
    public int peakIndexInMountainArray(int[] A) {
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i] >= A[i - 1]){
                res = i;
            }else{
                break;
            }
        }
        return res;
    }
}
