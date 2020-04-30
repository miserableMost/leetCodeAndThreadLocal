package newTest.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 */
public class T301_removeInvalidParentheses_9_16 {
    public static void main(String[] args) {

    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        //计算左右括号之差
        for (char c : s.toCharArray()) {
            if(c == '(') {
                left += 1;
            }else if(c == ')') {
                if(left > 0) {
                    left -= 1;
                }else {
                    right += 1;
                }
            }
        }
        count = left + right;
        Set<String> set = new HashSet<>();
        dfs(s,0,new StringBuilder(""),set,count);
        return new ArrayList<>(set);
    }
    //深度优先搜索
    private void dfs(String s, int i, StringBuilder sb, Set<String> set, int count) {
        if(count < 0)
            return;
        if(i == s.length()) {
            if(count == 0) {
                if(isValid(sb.toString())) {
                    set.add(sb.toString());
                }
            }
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if(c == '(' || c == ')') {
            dfs(s,i + 1,sb,set,count - 1);    //不用这个字符
            dfs(s,i + 1,sb.append(c),set,count);   //用这个字符
        }else {
            dfs(s,i + 1,sb.append(c),set,count);
        }
        sb.setLength(len);
    }
    //判断是否是有效括号
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                count ++;
            }else if(c == ')') {
                count --;
            }
            if(count < 0)
                return false;
        }
        return count == 0;
    }

}
