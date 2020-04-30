package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 448:找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 */
public class Test448_findDisappearedNumbers_25_REWRITE {
    public static void main(String[] args) {
         int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> re = findDisappearedNumbers(nums);
        for (Integer i : re) {
            System.out.print(i + " ");
        }
    }
    //我们假设数组序号0~n-1 应该放的是数字1~n，则遍历数组，将当前元素与其应该放的位置处的元素交换，知道该位置处放的是应该放的元素或者与交换处元素相等。
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if (nums==null)
            return list;
        for(int i=0;i<nums.length;)
        {
           // nums[i]==nums[nums[i]-1]表示准备去指定位置交换时元素重复
            if (nums[i]==i+1 || nums[i]==nums[nums[i]-1]  )
            {
                i++;
            }else {
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]!=i+1)
                list.add(i+1);
        }
        return list;


    }


    //定义一个交换的方法
    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        //j已经变成了以前的i
        arr[i] = arr[i] - arr[j];
        //交换方式--位异或
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        //3.交换
        arr[j] = arr[i] + arr[j] - (arr[i] = arr[j]);
    }
}
