package Test.October;

import java.util.Random;

/**
 * leetCode 384:打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 */
class Solution {

   /* public static void main(String[] args) {
        int[] array = {1,3};
        Solution solution = new Solution(array);
        solution.swap(0,1);
        System.out.println(Arrays.toString(array));
    }*/
    private int[] array;
    private int[] original;
    Random rand = new Random();

    private int randRange(int min,int max) {
        return rand.nextInt(max - min) + min;
    }
    //交换
    private void swap(int i,int j) {
        array[j] = array[i] + array[j] - (array[i] = array[j]);
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    //这一步模拟了每次从 “帽子” 里面摸一个元素的过程
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i,randRange(i,array.length));
        }
        return array;
    }
}
