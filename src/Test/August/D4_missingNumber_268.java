package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 268 :缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class D4_missingNumber_268 {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i <= len; i++) {
            if(!list.contains(i))
                return i;
        }
        return -1;
    }
}
