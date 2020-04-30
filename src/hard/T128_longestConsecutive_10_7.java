package hard;

import java.util.HashSet;
import java.util.Set;

/**  leetCode 128 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class T128_longestConsecutive_10_7 {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //定义一个返回结果
        int longestStreak = 0;
        for (int num : nums) {
            //只对每一个序列的头大哥开始操作
            if(!set.contains(num - 1)) {
                int currentStreak = 1;
                //查看下一个在不在
                while(set.contains(num + 1)) {
                    num = num + 1;
                    currentStreak ++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
