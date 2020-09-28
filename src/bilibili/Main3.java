package bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/9/4 18:37
 */
public class Main3 {
    public static void main(String[] args) {
        Main3 m3 = new Main3();
        int aaabbaaac = m3.GetFragment("aaabbaaac");
        System.out.println(aaabbaaac);
    }
    public int GetFragment (String str) {
        // write code here
        if(str == null || str.equals(""))
            return 0;
        Stack<Character> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int sum = 0;

            if(!stack.isEmpty() && stack.peek() != cur) {
                while(!stack.isEmpty() && stack.peek() != cur) {
                    stack.pop();
                    sum ++;
                }
                ans.add(sum);
            }

            stack.push(cur);
        }
        if(!stack.isEmpty()){
            ans.add(stack.size());
        }
        int res = 0;
        for (Integer i : ans) {
            res += i;
        }
        return res / ans.size();

    }
}
