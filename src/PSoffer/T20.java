package PSoffer;

import java.util.Stack;

/**
 * @author 李聪
 * @date 2019/12/22 14:45
 * 栈有可能满了，需要先弹出来
 * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106?f=discussion
 * 来源：牛客网
 *
 * 借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，
 * 这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，
 * 直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序
 */
public class T20 {
    public static void main(String[] args) {

    }
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length != popA.length)
            return false;
        if(pushA.length == 0)
            return false;
        int j = 0;  //表示弹出栈的位置
        Stack<Integer> stack = new Stack<>();
        for (int pA : pushA) {
            stack.push(pA);
            //我的这个元素就是你要弹的元素
            while(!stack.isEmpty() && popA[j] == stack.peek()) {
                j ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
