package newTest.array;

/** 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 */
public class T4_findMedianSortedArrays_9_18_REMEMBER {
    public static void main(String[] args) {

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int l1 = nums1.length;
       int l2 = nums2.length;
       //牢记
       int m = (l1 + l2 + 1) / 2;
       int n = (l1 + l2 + 2) / 2;
       //将奇偶情况进行合并
       return (getKth(nums1,0,l1 - 1,nums2,0,l2 - 1,m) + getKth(nums1,0,l1 - 1,nums2,0,l2 - 1,n)) * 0.5;
    }

    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //永远保持len1为较小的--这样数组为空的话一定是len1
        if(len1 > len2)
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        //短的已经为空
        if(len1 == 0)
            return nums2[start2 + k - 1];
        //最后一个
        if(k == 1)
            return Math.min(nums1[start1],nums2[start2]);
        //比较第i、j两元素大小
        int i = start1 + Math.min(len1,k / 2) - 1;    //避免短的数组越界
        int j = start2 + Math.min(len2,k / 2) - 1;
        if(nums1[i] > nums2[j]) {
            //数组2的较小
            return getKth(nums1,start1,end1,nums2,j + 1,end2,k - (j - start2 + 1));
        }else {
            return getKth(nums1,i + 1,end1,nums2,start2,end2,k - (i - start1 + 1));   //k要减去排除数组的元素
        }
    }
}
