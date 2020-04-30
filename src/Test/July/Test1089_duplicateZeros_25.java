package Test.July;

import java.util.ArrayList;

/**
 * leetCode 1089 :复写0
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，
 * 并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 。
 */
public class Test1089_duplicateZeros_25 {
    public static void main(String[] args) {
         int[] arr = {1,0,2,3,0,4,5,0};
         duplicateZeros(arr);
    }
    public static void duplicateZeros(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            arrList.add(arr[i]);
            if(arr[i]==0){
                arrList.add(0);
            }
            arr[i]=arrList.get(i);
        }
    }
}
