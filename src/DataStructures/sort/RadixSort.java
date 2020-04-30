package DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {


    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

       radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);


       /* int[] arr = {78,123,14,43,5,76,5,75};
        radixSort(arr);*/
    }

    public static void radixSort(int[] arr){
        //1.先得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length];    //防止溢出
        //为了记录每个桶中实际存放了多少数据，我们定义一个一维数组来记录各个桶每次放入的数据
        //理解:bucketElenmentCounts[0],它记录的是bucket[0]放入的数据个数
        int[] bucketElementCounts = new int[10];
        //使用循环将代码处理
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for(int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第l轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
            //System.out.println("第"+i+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        }



        //第一轮(针对每个元素的个位进行排序处理）

        //定义一个二维数组，便是10个桶，每个桶就是一个一维数组
        //很明显，基数排序是空间换时间
       /* int[][] bucket = new int[10][arr.length];    //防止溢出
        //为了记录每个桶中实际存放了多少数据，我们定义一个一维数组来记录各个桶每次放入的数据
        //理解:bucketElenmentCount[0],它记录的是bucket[0]放入的数据个数
        int[] bucketElementCount = new int[10];*/

        /*

		//第1轮(针对每个元素的个位进行排序处理)
		for(int j = 0; j < arr.length; j++) {
			//取出每个元素的个位的值
			int digitOfElement = arr[j] / 1 % 10;
			//放入到对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		//按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
		int index = 0;
		//遍历每一桶，并将桶中是数据，放入到原数组
		for(int k = 0; k < bucketElementCounts.length; k++) {
			//如果桶中，有数据，我们才放入到原数组
			if(bucketElementCounts[k] != 0) {
				//循环该桶即第k个桶(即第k个一维数组), 放入
				for(int l = 0; l < bucketElementCounts[k]; l++) {
					//取出元素放入到arr
					arr[index++] = bucket[k][l];
				}
			}
			//第l轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
			bucketElementCounts[k] = 0;

		}
		System.out.println("第1轮，对个位的排序处理 arr =" + Arrays.toString(arr));


		//==========================================

		//第2轮(针对每个元素的十位进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的十位的值
			int digitOfElement = arr[j] / 10  % 10; //748 / 10 => 74 % 10 => 4
			// 放入到对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
		index = 0;
		// 遍历每一桶，并将桶中是数据，放入到原数组
		for (int k = 0; k < bucketElementCounts.length; k++) {
			// 如果桶中，有数据，我们才放入到原数组
			if (bucketElementCounts[k] != 0) {
				// 循环该桶即第k个桶(即第k个一维数组), 放入
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素放入到arr
					arr[index++] = bucket[k][l];
				}
			}
			//第2轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
			bucketElementCounts[k] = 0;
		}
		System.out.println("第2轮，对个位的排序处理 arr =" + Arrays.toString(arr));


		//第3轮(针对每个元素的百位进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的百位的值
			int digitOfElement = arr[j] / 100 % 10; // 748 / 100 => 7 % 10 = 7
			// 放入到对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
		index = 0;
		// 遍历每一桶，并将桶中是数据，放入到原数组
		for (int k = 0; k < bucketElementCounts.length; k++) {
			// 如果桶中，有数据，我们才放入到原数组
			if (bucketElementCounts[k] != 0) {
				// 循环该桶即第k个桶(即第k个一维数组), 放入
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素放入到arr
					arr[index++] = bucket[k][l];
				}
			}
			//第3轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
			bucketElementCounts[k] = 0;
		}
		System.out.println("第3轮，对个位的排序处理 arr =" + Arrays.toString(arr)); */
    }
}
