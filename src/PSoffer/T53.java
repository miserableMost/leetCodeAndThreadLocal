package PSoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2019/12/29 18:12
 * 链接：https://www.nowcoder.com/questionTerminal/00de97733b8e4f97a3fb5c680ee10720?f=discussion
 * 来源：牛客网
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class T53 {
    private Map<Character,Integer> map = new HashMap<>();
    private ArrayList<Character> list = new ArrayList<>();
    public static void main(String[] args) {

    }
    public void Insert(char ch) {
        map.put(ch,map.getOrDefault(ch,0) + 1);
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char c = '#';
        for (char key : list) {
            if(map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }
}
