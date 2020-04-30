package Test.July;

import java.util.Stack;

/**
 * leetCode:844 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class Test844_backspaceCompare {

    public static void main(String[] args) {

    }



   // 使用栈是最简单的方法 扫描字符串S的每个字符，如果是'#'并且栈不为空，弹出栈顶的字符；
    // 如果为空，处理下一个字符。如果字符不是'#'，压入栈。对T进行同样的操作，最后比较两个栈是否一样。


    public static boolean backspaceCompare(String S, String T) {
       /* Stack<Character> s = invalid(S);
        Stack<Character> t = invalid(T);

        if(s.equals(t))
           return true;
        return false;*/
        return convert(S).equals(convert(T));
    }

    public static Stack<Character> invalid(String s){
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char t = s.charAt(i);
           if(t == '#' && !stack.isEmpty()){
               stack.pop();
           }else if(t != '#'){
               stack.push(t);
           }
        }
        return stack;

    }

    //不使用栈
    public static String convert(String s){
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '#'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
