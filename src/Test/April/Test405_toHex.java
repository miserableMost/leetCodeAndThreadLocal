package Test.April;


import java.util.Stack;

/**leetCode 405:数字转换为十六进制
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

 注意:

 十六进制中所有字母(a-f)都必须是小写。
 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 给定的数确保在32位有符号整数范围内。
 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

 示例 1：

 输入:
 26

 输出:
 "1a"

 * @author Hasee
 *
 */
public class Test405_toHex {

    public static void main(String[] args) {
        Test405_toHex test1 = new Test405_toHex();
        System.out.println(test1.toHex(-1));
    }

    public static String toHex(int num) {
        if (num == 0)
            return "-1";
        Stack<Character> stack = new Stack<>();
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int count = 0;//用来记录是否已经到第32位
        while (num != 0 && count < 8) {
            //0x表示16进制数
            int i = num & 0xf;//num低四位与16进制的f进行与运算，得到num的低四位16进制对应的整数
            stack.push(hex[i]);//查表，并入栈
            num = num >> 4;//右移四位
            count++;
        }
        String s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        return s;
    }
}