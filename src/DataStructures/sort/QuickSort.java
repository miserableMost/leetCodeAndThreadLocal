package DataStructures.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23,13,2,34,12,24};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        /*int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int) (Math.random() * 8000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

       quickSort(arr,0,arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);*/
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;   //左下标
        int r = right;  //右下标
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while(l < r){ //是让比pivot小的放到左边，大的放到右边
            //在pivot左边一直找，找到大于等于pivot值
            while(arr[l] < pivot){
                l++;
            }
            //在pivot右边一直找，找到小于等于pivot值
            while(arr[r] > pivot){
                r--;
            }
            //如果l >= r说明pivot的左右两的值，已经按照左边全部都是小于等于值，右边大于等于pivot
            if(l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现arr[l] == pivot 值相等,前移,这样减少了判断
            if(arr[l] == pivot){
                r --;
            }
            // //如果交换完后，发现arr[r] == pivot 值相等,后移
            if(arr[r] == pivot){
                l ++ ;
            }
        }
     /*   quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);*/
        //如果l == r,必须l++,r--,否则出现栈溢出
        if(l == r){
            l++;
            r--;
        }
        //向左递归
        if(left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right > r){
            quickSort(arr,l,right);
        }

    }
}
