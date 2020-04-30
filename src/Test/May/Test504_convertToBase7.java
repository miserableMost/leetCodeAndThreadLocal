package Test.May;

import java.util.Stack;

/**
 * leetCode 504:给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 示例 1:
 * 输入: 100
 * 输出: "202"
 */
public class Test504_convertToBase7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(1000));
    }


    public static String convertToBase7(int num) {
        int absN = Math.abs(num);
        Stack<Integer> s = new Stack<>();
        if(num == 0)
            return "0";
        while(absN != 0){
            int x = absN % 7;
            absN /= 7;
            s.push(x);
        }
        String re = "";
        if(num < 0){
            re += "-";
        }

        while(!s.isEmpty()){
            re = re + s.pop();
        }
        return re;
        /**
         *   最简单
         */
        //return Integer.toString(num,7);
    }
}
