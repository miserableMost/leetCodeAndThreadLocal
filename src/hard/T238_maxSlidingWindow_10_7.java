package hard;

import java.util.Arrays;
import java.util.LinkedList;

/** 239. 滑动窗口最大值
 * leetCode 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 */
public class T238_maxSlidingWindow_10_7 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
       if(nums.length == 0 || nums.length < 2)
           return nums;
       //定义一个双向队列
        LinkedList<Integer> list = new LinkedList<>();
        //定义一个结果数组
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //保证list永远递减
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            list.addLast(i);
            //删除过期的
            if(list.peek() <= i - k) {
                list.poll();
            }
            //窗口为k,从第k - 1个元素开始记录
            if(i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.peek()];
            }

        }
        return res;
    }
}
