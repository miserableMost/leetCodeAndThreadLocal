package hard.dp;

/**
 * @author 李聪
 * @date 2020/4/10 18:21
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]

 */
public class T321_拼接最大数 {

    public static void main(String[] args) {
        T321_拼接最大数 t = new T321_拼接最大数();
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int[] ints = t.maxNumber(nums1, nums2, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    /*
假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
*/
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)) res = arr;
        }
        return res;
    }

    /*
    假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3];
    n - i : 当前数组中,当前下标到结尾还有多少个元素;
    j : 当前数组中i之前有多少个数加入到最大组合中;
    n - i + j > k <=> n - i - 1 + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--,
    n - i(数组剩余元素) - 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k;
    if j < k : 先将最大组合填满再进行比较替换操作
     */
    private int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && nums[i] > res[j-1]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }

    /*
    假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
     */
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    /*
    比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
     */
    private boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
