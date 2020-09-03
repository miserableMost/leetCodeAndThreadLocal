package testAgin;

/**
 * @author 李聪
 * @date 2020/6/24 23:45
 * 寻找两个有序数组的中位数
 */
public class findMedianSort {
    public double findMedianSortArrays(int[] nums1,int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //如果n1+n2为奇数，m1,m2均为中间那个数，为偶数时，为中间两数
        int m1 = (n1 + n2 + 1) / 2;
        int m2 = (n1 + n2 + 2) / 2;
        return (findMedian(nums1,0,n1 - 1,nums2,0,n2 - 1,m1) + findMedian(nums1,0,n1 - 1,nums2,0,n2 - 1,m2))*0.5;

    }

    private int findMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //保证len永远是较小的
        if(len1 > len2) {
            findMedian(nums2,start2,end2,nums1,start1,end1,k);
        }
        //短的数组已经没了
        if(len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if(k == 0) {
            return Math.min(nums1[start1],nums2[start2]);
        }
        //比较两个数组的中位数
        int i = start1 + Math.min(len1,k/2) - 1;
        int j = start2 + Math.min(len2,k/2) - 1;
        if(nums1[i] < nums2[j]) {
            return findMedian(nums1,i + 1,end1,nums2,start2,end2,k -(i + 1 - start1));
        }else {
            return findMedian(nums1,start1,end1,nums2,j + 1,end2,k - (j + 1 - start2));
        }

    }


}
