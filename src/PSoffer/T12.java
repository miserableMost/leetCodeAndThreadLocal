package PSoffer;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2019/12/20 19:28
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class T12 {
    public static void main(String[] args) {
        T12 t12 = new T12();
        int[] arr = {1,3,4,6,5,2,9};
        t12.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void reOrderArray(int[] array) {
        if (array.length <= 1) {
            return;
        }
        //从右往左
    /*    for (int i = array.length - 1; i >= 0; i--) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) swap(array, j, j + 1);
            }
        }*/
        //从左往右
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j] % 2 == 1 && array[j - 1] % 2 == 0)
                    swap(array,j - 1,j);
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
