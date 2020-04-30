package PSoffer;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 李聪
 * @date 2019/12/19 15:04
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class T3 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> stack = new LinkedList<>();
        while(listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
