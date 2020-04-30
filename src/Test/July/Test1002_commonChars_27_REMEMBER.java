package Test.July;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 1002:查找常用字符串
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符
 * （包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，
 * 但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *

 */
public class Test1002_commonChars_27_REMEMBER {

    public static void main(String[] args) {
         String[] res = {"bella","label","roller"};
        List<String> strings = commonChars(res);
        System.out.println(strings);
    }
    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        //创建一个count用于存储每个字符出现的个数
        int[] count = new int[26];
        //以第一个数组为标杆，结果数组中的每个值必然比第一个数组小
        for (int i = 0; i < A[0].length(); i++) {
            count[A[0].charAt(i) - 'a'] ++;
        }
        for (int i = 1; i < A.length; i++) {
            //定义一个临时数组用于存储当前字符串情况
            int[] temp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                temp[A[i].charAt(j) - 'a'] ++;
            }
            for (int j = 0; j < 26; j++) {
                //与标杆比较，取较小值，没有的必然取0，temp有count没有的不必理会，
                // temp为0代表temp没有则count中也必须为0，此时肯定取temp中较小的0，
                // temp和count重复都有也取较小的
                if(temp[j] < count[j])
                    count[j] = temp[j];
            }
        }
        //遍历count
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 1){
                int p = 0;
                while(p < count[i]){
                    res.add((char)(i+'a')+"");
                    p ++;
                }
            }else if(count[i] == 1){
                res.add((char)(i+'a')+"");
            }
        }
        return res;
    }


}
