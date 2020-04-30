package DataStructures.sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];   //归并排序需要有个额外空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序："+ Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并方法

    /**
     *
     * @param arr    排序的原始数组
     * @param left   左边有序序列的初始索引
     * @param mid   中间索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;    //指向temp数组的当前嘴瘾

        //先将左右两边的数据按照规则填充到temp数组
        //直到有一边处理完毕
        while(i <= mid && j<=right){//继续
            //如果左边的有序序列的当前元素，小于右边有序序列的当前元素
            //即将左边的当前元素拷贝到temp
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {//反之，将右边有序数组的当前元素，拷贝到temp数组
                temp[t++] = arr[j++];
            }
        }
        //把有剩余数组的一边的数据一次全部填充到temp
         while(i <= mid) { //说明左边的有序序列还有剩余元素
             temp[t++] = arr[i++];
         }
         while(j <= right){
             temp[t++] = arr[j++]; //说明右边的有序序列还有剩余元素
         }
        //把temp数组的元素拷贝到arr
        //并不是每次都拷贝所有
         t = 0;
         int tempLeft = left;
         while(tempLeft <= right){   //第一次合并时，tempLeft = 0,right=1;
             arr[tempLeft++] = temp[t++];

         }
    }
}
