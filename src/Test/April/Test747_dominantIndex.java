package Test.April;

import java.util.Arrays;

/**
 * leetCode 747:至少是其他数字两倍的最大数
 * 注意：只有一个数时，返回0
 *在一个给定的数组nums中，总是存在一个最大元素 。
 *查找数组中的最大元素是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的索引，否则返回-1。
 示例 1:
 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 示例 2输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 */
public class Test747_dominantIndex {
    public static void main(String[] args) {
          Test747_dominantIndex test = new Test747_dominantIndex();
          int[] nums = {0,0,2,1};
        System.out.println(test.dominantIndex(nums));
    }


    public int dominantIndex(int[] nums) {

        //只有一个数时，返回自身
        if(nums.length<2)
            return 0;
        int index = findMax(nums);
        int max = nums[index];
      /*  //去掉那个最大数剩下的数组
        int[] newNums = new int[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(i<index){
                newNums[i] = nums[i];
            }else if(i>index){
                newNums[i-1] = nums[i];
            }
        }*/
        //直接排序跟第二大数比较
        Arrays.sort(nums);


        //找到第二大的数
        //int newMax = findMax(newNums);
        if(max >= nums[nums.length-2]*2){
            return index;
        }else {
            return -1;
        }
      /*  for(int i=0;i<newNums.length;i++){
            System.out.print(newNums[i]+"  ");
        }*/

    }
    //找到数组中最大值的索引
    public static int findMax(int[] nums){
        if(nums.length==1){
            return 0;
        }
        int maxNum = nums[0];
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>maxNum){
                maxNum = nums[i];
                index = i;
            }
        }
        return index;
    }
}
