package testAgin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * @date 2020/9/16 15:49
 */
public class CountSub {
    public static void main(String[] args) {
        int x = 27893;
        int rev = 0;
        List<Integer> an = new ArrayList<>();
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            an.add(pop);
            rev = rev * 10 + pop;
        }
        for (Integer i : an) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(rev);

       /* String s1 = "abds";
        String s2 = "bd";
        System.out.println(s1.indexOf(s2));*/
    }
    public static int countSub(String s1,String s2){
        int count = 0;
        int index = 0;
        while((index = s1.indexOf(s2)) != -1){
            count ++;
            s1 = s1.substring(index + 1);
        }


        return count;
    }
}
