package Test.July;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 893:特殊等价字符
 * 你将得到一个字符串数组 A。
 *
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 *
 * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
 *
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 *
 * 返回 A 中特殊等价字符串组的数量。

 */
public class Test893_numSpecialEquivGroups_30_REMEMBER {
    public static void main(String[] args) {

    }
    //单个字符串也算一个
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for (String s : A) {
            //分成奇偶，偶数放在后26位
            int[] temp = new int[52];
            for (int i = 0; i < s.length(); i++) {
                temp[s.charAt(i) - 'a' + 26 * (i % 2)] ++;
            }
            seen.add(Arrays.toString(temp));
        }
        return seen.size();
    }
}
