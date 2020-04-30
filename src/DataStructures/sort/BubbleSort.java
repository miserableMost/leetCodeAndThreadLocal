package DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
        //测试一下冒泡排序的速度，给8万个数据
        //创建一个80000个随机的数组
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = (int) (Math.random() * 1000000); //生成0-80000数
        }
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = dateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);
        //测试冒泡排序
        bobbleSort(arr);
        Date date2 = new Date();
        String date2Str = dateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);




       /* //第二趟排序，就是将第二大大的数排到倒数第二位
        for (int i = 0; i < arr.length - 1-1; i++) {
            //如果前面的数比后面的数大，则交换
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，就是将第三大大的数排到倒数第三位
        for (int i = 0; i < arr.length - 1 -2; i++) {
            //如果前面的数比后面的数大，则交换
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，就是将第四大大的数排到倒数第四位
        for (int i = 0; i < arr.length - 1 -3; i++) {
            //如果前面的数比后面的数大，则交换
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/
    }
    public static void bobbleSort(int[] arr){
        //为了容易理解，我们把冒泡排序的过程显示出来
        //第一趟排序，就是将最大的数排到最后
        int temp = 0;  //临时变量
        boolean flag = false;  //表示是否进行过交换
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                //如果前面的数比后面的数大，则交换
                if(arr[i] > arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
          /*  System.out.println("第"+(j+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));*/
            if(flag == false){     //在一趟排序中，一次交换都没有发生
                break;
            }else{
                flag = false;          //重置成false,方便下次
            }
        }
    }
}
