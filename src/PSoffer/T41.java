package PSoffer;

import java.util.ArrayList;

/**
 * @author 李聪
 * @date 2019/12/28 11:17
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class T41 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,8};
        T41 t41 = new T41();
        ArrayList<Integer> list = t41.FindNumbersWithSum(arr, 8);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        int left = 0;
        int right = array.length - 1;
        int min = Integer.MAX_VALUE;
        //定义一个返回集合
        ArrayList<Integer> ans = new ArrayList<>();
        if(array.length < 2)
            return ans;
        while(left < right) {
            int num = array[left] + array[right];
            if(num == sum){
                if(array[left] * array[right] < min) {
                    ans.add(array[left]);
                    ans.add(array[right]);
                    min = array[left] * array[right];
                }
                left ++;
            }else if(num < sum) {
                left ++;
            }else {
                right --;
            }
         }
        return ans;
    }
}