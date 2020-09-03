package tryTest;

import java.math.BigInteger;
import java.util.*;

/**
 * @author 李聪
 * @date 2020/6/20 22:43
 */
public class Test_计算器 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(caculate("1+2*(12+8) - 10"));

        List<Integer> ans = new ArrayList<>();
        for (Integer an : ans) {
            System.out.print("");
        }
        BigInteger m = new BigInteger("1231243");


    }


    public static int caculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if(c != ' ')
                queue.offer(c);
        }
        queue.offer('+');
        return caculate(queue);
    }
    public static int caculate(Queue<Character> queue) {
       /* Map<Character,Integer> map = new HashMap<>();
        char[] m = {'a','s','s'};
        for (char c : m) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }*/


        Character sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            Character c = queue.poll();
            if(Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }else if(c == '(') {
                num = caculate(queue);
            }else {
                if(sign == '+') {
                    stack.push(num);
                }else if(sign == '-') {
                    stack.push(-num);
                }else if(sign == '*') {
                    stack.push(stack.pop() * num);
                }else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
                if(c == ')')
                    break;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
