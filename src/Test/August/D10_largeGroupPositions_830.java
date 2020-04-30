package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 830 :较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 */
public class D10_largeGroupPositions_830 {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcddd";
        List<List<Integer>> lists = largeGroupPositions(s);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char pre = S.charAt(0);
        int start = 0;
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if(cur == pre){
                count ++;

            }else{
                //发生改变了，检查上一波count是否大于等于3
                if(count >= 3){
                    List<Integer> temp = new ArrayList<>();

                    temp.add(start);
                    temp.add(i - 1);
                    res.add(temp);
                }
                start = i;
                count = 1;
            }
            pre = cur;
            //如果遍历到了最后
            if(i == S.length() - 1 && count >= 3){
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(i);
                res.add(temp);
            }

        }
        return res;
    }
}
