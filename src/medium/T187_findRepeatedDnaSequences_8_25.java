package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetCode 187:重复的DNA序列
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）
 *
 */
public class T187_findRepeatedDnaSequences_8_25 {
    public static void main(String[] args) {

    }

    public List<String> findRepeatedDnaSequences(String s) {
         List<String> res = new ArrayList<>();
         if(s.length() < 10)
             return res;
        Set<String> set1 = new HashSet<>(); ///存储已经遍历过的子字符串
        Set<String> set2 = new HashSet<>();  //存储符合条件的子字符串
        for (int i = 0; i + 10 <= s.length(); i++) {
            String seq = s.substring(i,i + 10);
            if(set1.contains(seq)){
                set2.add(seq);
            }
            set1.add(seq);
        }
        res.addAll(set2);
        return res;

    }
}
