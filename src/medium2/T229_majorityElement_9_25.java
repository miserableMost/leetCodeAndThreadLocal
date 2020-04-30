package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 *
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class T229_majorityElement_9_25 {
    public static void main(String[] args) {

    }

    /**
     * 摩尔投票法。该算法用于1/2情况，它说：“在任何数组中，出现次数大于该数组长度一半的值只能有一个。”
     *
     * 那么，改进一下用于1/3。可以着么说：“在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。”
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        /**
         首先可以明确的一点是，这样的元素可能有0个、1个、或者2个，再没有别的情况了.
         然后，求众数I 里的 Boyer-Moore 算法思路在这里依然可用，但需要些改动：
         1) 满足条件的元素最多有两个，那么需要两组变量. count, major变成了
         count1, major1; count2, major2;
         2) 选出的两个元素，需要验证它们的出现次数是否真的满足条件.
         **/
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }else if(count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                num2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }
        }

        if(count1 > nums.length / 3) res.add(num1);
        if(count2 > nums.length / 3) res.add(num2);

        return res;

    }
}
