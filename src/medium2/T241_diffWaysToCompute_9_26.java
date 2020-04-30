package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 */
public class T241_diffWaysToCompute_9_26 {
    public static void main(String[] args) {
        T241_diffWaysToCompute_9_26 test = new T241_diffWaysToCompute_9_26();
        List<Integer> list = test.diffWaysToCompute("2-1-1");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public List<Integer> diffWaysToCompute(String input) {

        return partition(input);
    }

    private List<Integer> partition(String input) {
        //需要的是单个值
        List<Integer> ans = new ArrayList<>();
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            ans.add(Integer.valueOf(input));
            return ans;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                for (Integer left : partition(input.substring(0, i))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if(c == '+') {
                            ans.add(left + right);
                        }else if(c == '-') {
                            ans.add(left - right);
                        }else if(c == '*') {
                            ans.add(left * right);
                        }
                    }
                }
            }

        }
        return ans;
    }
}
