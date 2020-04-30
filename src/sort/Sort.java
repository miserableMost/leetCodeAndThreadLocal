package sort;

import java.util.ArrayList;

public class Sort {
    public static void main(String[] args) {
        String[] arr = {"ied","iad","ica"};
        radixSortA(arr,3);
        for (String s : arr) {
            System.out.print(s+" ");
        }
         /*Integer[] a = {81,94,11,96,12,35,17,95,28,58,41,75,15};
         shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }*/
    }



    //插入排序例程
    public static <Integer extends Comparable<? super Integer>> void insertSort(Integer[] a){
        int j ;
        for (int p = 1; p < a.length; p++) {
            Integer tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j-1];
                a[j] = tmp;
            }
        }
    }

    public static <Integer extends Comparable<? super Integer>> void shellSort(Integer[] a){
        int j;
        for (int gap = a.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                Integer tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j-gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    public static void radixSortA(String[] arr,int stringLen){
        final int BUCKET = 256;
        ArrayList[] buckets = new ArrayList[ BUCKET ];
        //每一个bucket初始化
        for (int i = 0; i < BUCKET; i++) {
            buckets[i] = new ArrayList();
        }
        for (int pos = stringLen - 1; pos >= 0 ; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }

            int idx = 0;
            for (ArrayList thisBucket : buckets){
                for (Object s : thisBucket) {
                    arr[idx++] = s.toString();
                }
                thisBucket.clear();
            }


        }

    }
}
