package Test.July;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetCode 496:下一个更大元素
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出-1
 *示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 */
public class Test496_nextGreaterElement_REMEMBER {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }

   //由于nums1是nums2子集，只需知道nums2的下一个最大元素即可
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
      //创建一个栈用于存nums2
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int n2 : nums2) {
            //当栈不为空时,即将压入的数为n2，看压入的数是否是栈顶元素的下一个更大元素
            while(!stack.isEmpty() && stack.peek() < n2){
                //使用hashMap记录栈顶的下一个更大元素，并将已经找到下一个更大元素的数弹出
                hashMap.put(stack.pop(),n2);
            }
            //将此数压入栈
            stack.push(n2);
        }
        int length = nums1.length;
        //定义返回结果数组
        int[] result = new int[nums1.length];
        for (int i = 0; i < length; i++) {
            result[i] = hashMap.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
