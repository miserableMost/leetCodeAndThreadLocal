package medium2;

/**
 * leetCode 338 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 *
 *     给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 *     要求算法的空间复杂度为O(n)。
 *     你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class T338_countBits_10_8 {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        //引用类型
        int[] nums1 = nums;
        String s = "sdewr\\n";
        System.out.println(s);
      /*  System.out.println(Arrays.toString(nums1));
        nums[0] = 3;
        System.out.println(Arrays.toString(nums1));*/
    }
    //i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，
    // 而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
       //最后设置为是从右到左第一个为1的位，将其设置为0
        for (int i = 1; i <= num; i++) {  ////注意要从1开始，0不满足
            res[i] = res[i & (i- 1)] + 1;
        }
        return res;
    }
   /* public int[] countBits(int num) {
        int[] res = new int[num + 1];
        //将最后一位移掉,再判断最后一位是否为1
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }*/
}
