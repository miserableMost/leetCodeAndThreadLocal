package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * leetCode 17 : 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class T17_letterCombinations_8_27 {
    public static void main(String[] args) {
        letterCombinations("23");
    }
    public static List<String> letterCombinations(String digits) {
        //定义一个队列
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //从空开始
        ans.add("");
        for(int i =0; i < digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()== i){   //长度短的都出队列
                //队列头出去
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    //拼上后加到队尾
                    ans.add(t+s);
            }
        }
        return ans;


    }
}
