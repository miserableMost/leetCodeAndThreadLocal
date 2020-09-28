package xiaomi;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/8 17:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            boolean number = false;
            boolean sign = false;
            boolean bigDigit = false;
            boolean littleDigit = false;
            String cur = str[i];
            if(cur.length() < 8 || cur.length() > 120){
                System.out.println(1);
                continue;
            }
            for (int j = 0; j < cur.length(); j++) {
                char curChar = cur.charAt(j);
                if(curChar >= '0' && curChar <= '9'){
                    number = true;
                    continue;
                }
                if(curChar >= 'A' && curChar <= 'Z'){
                    bigDigit = true;
                    continue;
                }
                if(curChar >= 'a' && curChar <= 'z'){
                    littleDigit = true;
                    continue;
                }
                sign = true;
            }
            if(number && sign && bigDigit && littleDigit){
                System.out.println(0);
            }else {
                System.out.println(2);
            }


        }
    }
}
