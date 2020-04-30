package medium;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * leetCode 31 : 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class T31_nextPermutation {
    public static void main(String[] args) {
        new LinkedList<>();
        new HashMap<>();

    }
    public void nextPermutation(int[] nums) {
        //对于任何给定序列的降序，没有可能的下一个更大的排列
        int i = nums.length - 2;       //从倒数第二个数开始
        //需要从右边找到第一对两个连续的数字 a[i]a[i]a[i] 和 a[i−1]a[i-1]a[i−1]，它们满足 a[i]>a[i−1]a[i]>a[i-1]a[i]>a[i−1]
        while(i >= 0 && nums[i + 1] <= nums[i]) {
            i --;
        }
        if(i >= 0) {
            //从后面开始找，正好找到一个比目前大的为止，然后再反转
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j --;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1);
    }
    //将起始位置到最后位置反转
    private void reverse(int[] nums,int start) {
        int i = start;
        int j = nums.length - 1;
        while(i < j) {
            swap(nums,i,j);
            i ++;
            j --;
        }
    }

    //数组中两数交换
    private void swap(int[] nums,int i,int j) {
        nums[j] = nums[i] + nums[j] - (nums[i] = nums[j]);
    }
}
