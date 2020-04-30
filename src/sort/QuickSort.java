package sort;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/4/22 8:12
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {20,6,1,9,23,45,23,12,90,78,56};
        quickSort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums,int left,int right) {
        /*if(left>right)
            return;
        int pivot=a[left];//定义基准值为数组第一个数
        int i=left;
        int j=right;

        while(i<j)
        {
            while(pivot<=a[j]&&i<j)//从右往左找比基准值小的数
                j--;
            while(pivot>=a[i]&&i<j)//从左往右找比基准值大的数
                i++;
            if(i<j)                     //如果i<j，交换它们
            {
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        a[left]=a[i];
        a[i]=pivot;//把基准值放到合适的位置
        quickSort(a,left,i-1);//对左边的子数组进行快速排序
        quickSort(a,i+1,right);//对右边的子数组进行快速排序*/
        if(left > right)
            return;
        int priot = nums[left];
        int l = left,r = right;
        while(l < r) {
            //必须先从右边找比它小的
            while(l < r && nums[r] >= priot) {
                r --;
            }
            while(l < r && nums[l] <= priot) {
                l ++;
            }
            if(l < r) {
                swap(nums,l,r);
            }

        }
        nums[left] = nums[l];
        nums[l] = priot;
        quickSort(nums,left,l - 1);
        quickSort(nums,l + 1,right);
    }

    private static void swap(int[] nums, int left, int right) {
        nums[left] = nums[left] + nums[right] - (nums[right] = nums[left]);
    }
}
