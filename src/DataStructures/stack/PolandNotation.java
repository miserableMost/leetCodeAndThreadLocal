package DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转为后缀表达式的功能
        //说明
        //将得到的中缀表达式对应的list =>后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式："+infixExpressionList);
        System.out.println();
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list" + parseSuffixExpressionList);
        System.out.printf("expression=%d",calculate(parseSuffixExpressionList));
        //先定义逆波兰表达式
        //说明为了方便，逆波拉表达式的数字和符号使用空格隔开
        /*String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //11.先将 "3 4 + 5 * 6 -" => 放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("计算的结果是： "+res);*/
    }
    //将得到的中缀表达式对应的list =>后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<>();   //存储中间结果的list

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); ///!!!将（弹出s1栈，消除小括号
            }else{
                //当item的运算符的优先级小于等于栈顶的优先级
                //问题;我们缺少一个比较优先级的方法
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    //弹出去
                    s2.add(s1.pop());
                }
                //让item压入栈中
                s1.push(item);
            }
        }
        //将s1中的剩余的运算符一次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    //方法：将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放在中缀表达式的内容
        List<String> ls = new ArrayList<>();
        int i = 0;//这时是一个指针，用于遍历中缀表达式字符串
        String str;   //对多位数的拼接
        char c;   //每遍历一个字符，就放入到c
        do{
            //如果c是一个非数字，就加入到ls
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add(""+c);
                i++ ;  //i需要后移
            }else{ //如果是一个数，需要考虑多位数
                str = ""; //先将str置成空串
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <=57){
                    str += c; //拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }


    //将一个逆波兰表达式，一次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return  list;
    }
    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式取出数
            if(item.matches("\\d+")){
                //匹配的是多位数
                stack.push(item);
            }else{
                //pop出两个数，并运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw  new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res+"");
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}
//编写一个类，可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}


