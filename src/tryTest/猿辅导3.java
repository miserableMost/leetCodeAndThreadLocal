package tryTest;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/7/26 11:19
 */
public class 猿辅导3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c =  Integer.parseInt(sc.nextLine());

        String[] strs = new String[c];
        for (int i = 0; i < c; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < c; i++) {
            String m = solution(strs[i]);
            System.out.println(m);
        }
    }
    public static String solution(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int i = 0,j = 0;
        while(i < len) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(ans.length());
                i ++;
            }else if(c >= 'A' && c <= 'Z'){
                ans.append(c);
                i ++;
            }else if(c >= '0' && c <= '9'){
                j = i;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i ++;
                }
                ans.append(repeat(ans.substring(ans.length() - 1),Integer.parseInt(s.substring(j,i)) - 1));
            }else if(c == ')'){
                i ++;
                j = i;
                while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    i ++;
                }
                ans.append(repeat(ans.substring(stack.pop()),Integer.parseInt(s.substring(j,i)) - 1));
            }
        }
        return ans.toString();

    }
    public static String repeat(String str,int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
