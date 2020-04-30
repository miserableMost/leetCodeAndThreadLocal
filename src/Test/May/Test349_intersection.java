package Test.May;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 349:两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

public class Test349_intersection {
    public static void main(String[] args) {
        int[] n1 = {1};
        int[] n2 = {9,4,9,8,4};
        int[] ints = intersection(n1, n2);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
          /*int len1 = nums1.length;
          int len2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(nums1[i] == nums2[j] && (!list.contains(nums1[i]))){
                    list.add(nums1[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;*/
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                 //使用nums2返回,避免创造新数组占用空间
                 nums2[index++] = nums2[i];
                 //存在就将其删掉
                 set.remove(nums2[i]);
            }
        }
        //复制数组，包含头不包含尾
        return Arrays.copyOfRange(nums2,0,index);
    }
}
