package Test.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示
 */
public class D1_findWords_500 {
    public static void main(String[] args) {
        D1_findWords_500 d = new D1_findWords_500();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words1 = d.findWords(words);
        System.out.println(Arrays.toString(words1));
    }
    public String[] findWords(String[] words) {
          if(words == null)
              return null;
          //定义一个字典行
        // 字典行
        String lines[] = new String[] {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        //定义一个集合存放结果
        List<String> res = new ArrayList<>();
        //循环判断
        int loc = 0;
        for (int i = 0; i < words.length; i++) {
            //判断是否添加
            boolean add = true;
            String low = words[i].toLowerCase();
            //判断在哪个lines
            loc = location(lines, low);
            for (int j = 0; j < low.length(); j++) {
                //存在某个不相等
                if(lines[loc].indexOf(low.charAt(j)) == -1){
                    add = false;
                    break;
                }
            }
            //add为true则可以添加
            if(add) res.add(words[i]);

        }
        return  res.toArray(new String[res.size()]);

    }
    //此方法用于判断在哪个lines
    public int location(String[] lines,String s) {
        for (int i = 0; i < lines.length; i++) {
            if(lines[i].indexOf(s.charAt(0)) != -1)
                return i;
        }
        return -1;

    }

}
