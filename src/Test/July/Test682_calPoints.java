package Test.July;

import java.util.Stack;

/**
 * leetCode 682: 棒球比赛
 *  你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * 示例 1:
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
*/
public class Test682_calPoints {
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int i = calPoints(ops);
        System.out.println(i);
    }
    //思路：
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int length = ops.length;
        for (int i = 0; i < length; i++) {
            if(ops[i].equals("C") && !stack.isEmpty()){
                stack.pop();
                //"D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
            }else if(ops[i].equals("D") && !stack.isEmpty()){
                int value = stack.pop();
                //将弹出的值再压入
                stack.push(value);
                stack.push(value*2);
            }else if(ops[i].equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2);
                stack.push(n1);
                stack.push(n1+n2);
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
