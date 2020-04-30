package Test.July;

import java.util.Stack;

/**
 * leetCode 1047:删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一
 */
public class Test1047_removeDuplicates {
    public static void main(String[] args) {
        String sql = "abbaca";
        String res = removeDuplicates(sql);
        System.out.println(res);
    }

    public static String removeDuplicates(String S) {
        int length = S.length();
        StringBuffer sb  = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        //遍历栈--增强for循环
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();

    }

}
