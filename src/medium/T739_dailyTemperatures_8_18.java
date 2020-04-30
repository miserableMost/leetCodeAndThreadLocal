package medium;

import java.util.Stack;

/**
 * leetCode 739 : 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 */
public class T739_dailyTemperatures_8_18 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0 ; i++) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
