package Test.May;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode: 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 */
public class Test345_reverseVowels {
    public static void main(String[] args) {
        String  s= "Live on evasions? No, I save no evil.";
        System.out.println(reverseVowels(s));
    }




    public static String reverseVowels(String s) {
        //创建一个数组记录位置
        List<Integer> index = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            switch (ch){
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    index.add(i);
            }


        }
        int j = index.size();
        if (j <= 1)
            return s;
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < index.size() / 2; i++) {
            //获取字符串中对应的位置
            Integer begin = index.get(i);
            char temp = sb.charAt(begin);
            Integer last = index.get(j-1);
            char x = s.charAt(last);

            sb.replace(begin,begin+1,x+"");
            sb.replace(last,last+1,temp+"");
            j --;
        }
        return sb.toString();

    }
}
