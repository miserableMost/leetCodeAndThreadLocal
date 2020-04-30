package Test.August;

import java.util.*;

/**
 * leetCode 1122 : 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 *     arr2 中的元素各不相同
 *     arr2 中的每个元素都出现在 arr1 中
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 */
public class D11_relativeSortArray_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ints = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //创建一个表
        int[] count = new int[1001];
        //创建一个返回数组
        int[] res = new int[arr1.length];
        //遍历arr1
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]] ++;
        }
        int index = 0;  //记录返回数组的指标
        for (int i = 0; i < arr2.length; i++) {
            //先处理在arr2中存在的数
            while(count[arr2[i]] > 0){
                res[index ++] = arr2[i];
                count[arr2[i]] --;
            }
        }
        //记录剩下的
        for (int i = 0; i < 1001; i++) {
            //注意有相同的，因此使用while
            while(count[i] > 0){
                res[index ++] = i;
                count[i] --;
            }

        }
        return res;

    }
}
