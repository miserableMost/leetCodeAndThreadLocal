package Test.August;

import java.util.Arrays;

/**
 * leetCode 88:合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class D4_merge_88 {
    public static void main(String[] args) {
         int[] nums1 = {1,2,3,0,0,0};
         int m = 3;
         int[] nums2 = {2,5,6};
         int n = 3;
         merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
         //定义一个临时数组
        int[] temp = new int[m + n];
        int i = 0,j = 0;
        int p = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                temp[p ++] = nums1[i];
                i ++;
            }else{
                temp[p ++] = nums2[j];
                j ++;
            }
        }
        while(i < m){
            temp[p ++] = nums1[i ++];
        }
        while(j < n){
            temp[p ++] = nums2[j ++];
        }
        //拷贝回去
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
