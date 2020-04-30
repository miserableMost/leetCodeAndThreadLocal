package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 6 : Z字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 输出: "LCIRETOESIIGEDHN"
 */
public class T6_convert {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        List<StringBuffer> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            ans.add(new StringBuffer());
        }
        int curRow = 0; //定义一个当前行
        boolean goDown = false;  //是否去下一行
        for (char c : s.toCharArray()) {
            ans.get(curRow).append(c);
            //处在第一行或者最后一行
            if(curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;   //经典操作
            curRow += goDown ?  1 : -1;
        }


        StringBuffer sb = new StringBuffer();
        for (StringBuffer an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }
}
