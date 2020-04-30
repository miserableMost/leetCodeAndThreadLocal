package Test.April;

import java.util.ArrayList;
import java.util.List;
/**
 * leetCode : 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 */
public class Test438_findAnagrams {
    public static void main(String[] args) {
        String s = "aaaab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams2(s, p);
        for (Integer it : anagrams) {
            System.out.println(it);
        }


    }



    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen)
            return list;

        //外层循环,只需到s-p的长度即可，不断在对一个 p 长度大小的子串进行遍历
        for (int i = 0; i <= sLen - pLen; i++) {
            //此数组用于记录，26个字母以及每个字母出现的频数
            int[] save = new int[26];
            //标志是否添加
            boolean flag = true;
            for (int j = 0; j < pLen; j++) {
                //将s中连续的p字符串长度的字符添加进记录数组
                save[s.charAt(i+j)-'a'] ++;
                //将记录数组中，p字符串对应的删除，这样做就无须考虑顺序
                save[p.charAt(j)-'a'] --;
            }
            //将这一波操作后的记录数组遍历,全为0则表示得行
            for (int j = 0; j < save.length; j++) {
                if(save[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        return list;
    }
    //滑动窗口:循环右移的过程中，如果当前字符包含在 p 中，那么差异度减一，
    // 同时维护 hash 数组对应的值减一。如果差异度为 0 了，也就是子串符合要求了
    // ，则将滑动窗口的左边界加入结果集。当滑动窗口的大小等于 p 的长度时，
    // 就需要将滑动窗口的左边界右移一位，并维护 hash 数组的值加一，
    // 同时判断左边界当前的值是否大于等于 0 ：因为如果是小于 0，
    // 也就是第一个 if 语句中减一之后变为负数的，说明在 p 中不存在，差异度无须恢复；
    // 如果存在，那么把差异度恢复加一。
    //最后右边界到达终点，循环结束，返回记录下的起始索引即可。

    public static List<Integer> findAnagrams2(String s, String p){
        List<Integer> result = new ArrayList<>();
        //判断是否为空
        if(s.length() == 0 || s == null || p.length() == 0 || p == null)
            return result;
        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c-'a'] ++;
        }
        //定义滑动窗口,count 表示这段与p同样长的窗口与P的差异度
        int left = 0,right = 0,count = p.length();
        while(right < s.length()){
            //用i来表示位置
            int i = s.charAt(right)-'a';
            //如果s的元素在hash中存在
            if(hash[i] > 0){
                count --;
            }

            hash[i]--;
            right ++;
            //差异度为0，自然返回
            if(count == 0)
                result.add(left);
            //注意：此时的right并非指针停留的地方，而是right+1，并且尚未与hash比较
            if(right - left == p.length()){
                int j = s.charAt(left) - 'a';
                //窗口移动，需要left右移，同时去掉原left的影响
                if(hash[j] >= 0){
                    count ++;
                }
                //把left对应的元素加上
                hash[j] ++;
                left ++;
            }


        }

    return result;
    }

}
