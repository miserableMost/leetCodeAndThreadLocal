package Test.August;

/**
 * leetCOde 521;最长特殊序列
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 */
public class D2_findLUSlength_521 {
    public static void main(String[] args) {

    }
    public int findLUSlength(String a, String b) {
        //相等则返回-1
         if(a.equals(b))
             return -1;
         //否则返回字符串长度较长的那个
         else
             return Math.max(a.length(),b.length());
    }
}
