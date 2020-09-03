package testAgin;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/7/8 21:13
 */
public class Te2 {
    public static void main(String[] args) {
        int[] ans = {5,4,3,2,1};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[ans.length];
        Arrays.fill(res,-1);
        for (int i = ans.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && ans[i] > ans[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = ans[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));

    }
}
