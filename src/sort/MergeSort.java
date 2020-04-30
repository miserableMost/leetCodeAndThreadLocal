package sort;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/22 9:12
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,31,1,23,34,56,12,14};
        sort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    private static void sort(int[] nums,int left,int right){
        if(left >= right)   //只有一个元素时结束递归
            return;
        int mid = left + (right - left) / 2;
        //先把左右排好
        sort(nums,left,mid - 1);
        sort(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }
    private static void merge(int[] nums,int left,int mid,int right) {
        int[] temp = new int[nums.length];
        int i = left;
        int l = left,r = mid + 1;
        while(l <= mid && r <= right) {
            if(nums[l] < nums[r]) {
                temp[i ++] = nums[l ++];

            }else {
                temp[i ++] = nums[r ++];

            }
        }
        while(l <= mid) {
            temp[i ++] = nums[l];
            l ++;
        }
        while(r <= right) {
            temp[i ++] = nums[r];
            r ++;
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
        }
    }


}
