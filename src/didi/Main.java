package didi;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/13 18:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int len = str.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += n) {
            String curStr = "";
            if(i + n >= len) {
                curStr = reverse(str.substring(i));
            }else {
                curStr = reverse(str.substring(i,i + n));
            }

            sb.append(curStr);

        }
        System.out.println(sb.toString());

    }
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
