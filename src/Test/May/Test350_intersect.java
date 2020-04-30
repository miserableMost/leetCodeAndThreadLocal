package Test.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetCode: 350. 两个数组的交集 II
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *  我们可以不考虑输出结果的顺序。
 */
public class Test350_intersect {
    public static void main(String[] args) {

        int[] n1 = {1,2,2,1};
        int[] n2 = {2};
        int[] intersect = intersect(n1, n2);
        for (int i : intersect) {
            System.out.print(i+" ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(list.contains(nums2[i])){
                nums2[index++] = nums2[i];
                //此时remove表示的是删除集合中第一个出现的Object o;
                list.remove((Object)nums2[i]);
            }
        }
        return Arrays.copyOfRange(nums2,0,index);
    }
}
