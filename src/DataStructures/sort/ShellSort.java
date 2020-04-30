package DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort(arr);//交换式
        shellSort2(arr); //移位式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }


    //使用逐步推导的方式来编写希尔排序
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        //根据逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0 ; gap/=2) {
            //希尔排序的第一轮排序
            //因为第一轮排序，是将10个数据分成了五组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组所有的元素（共五组，每组两个元素），步长为5
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    //如果当前元素大于加上步长后的那个元素
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序的第"+(++count)+"排序后"+ Arrays.toString(arr));
        }



        /*System.out.println("希尔排序一轮后："+ Arrays.toString(arr));
        //第二轮排序
        for (int i = 2; i < arr.length; i++) {
            //遍历各组所有的元素（共五组，每组两个元素），步长为5
            for (int j = i-2; j >= 0 ; j-=2) {
                //如果当前元素大于加上步长后的那个元素
                if(arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序一轮后："+ Arrays.toString(arr));
        //第三轮排序
        for (int i = 1; i < arr.length; i++) {
            //遍历各组所有的元素（共五组，每组两个元素），步长为5
            for (int j = i-1; j >= 0 ; j-=1) {
                //如果当前元素大于加上步长后的那个元素
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序一轮后："+ Arrays.toString(arr));*/
    }
    //对交换式的希尔排序进行优化-》移位法
    public static void shellSort2(int[] arr){
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0 ; gap/=2){
            //对第gap个元素，每组逐个采用直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j-gap >= 0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出循环时，找到了插入位置
                    arr[j] = temp;
                }
            }
        }
    }
}
