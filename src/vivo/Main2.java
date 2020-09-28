package vivo;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/12 20:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /*if(isValid(str)){
            System.out.println(str);
            return;
        }*/
        for(int i = 0;i < str.length();i ++) {
            String arr = "";
            if(i != str.length() - 1){
                arr = str.substring(0,i) + str.substring(i + 1,str.length());
            }else {
                arr = str.substring(0,i);
            }
            if(isValid(arr)){
                System.out.println(arr);
                return;
            }
        }
        System.out.println("false");
    }

    public static boolean isValid(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
