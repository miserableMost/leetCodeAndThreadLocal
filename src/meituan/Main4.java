package meituan;

import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        String[] strs = new String[M];
        for (int i = 0; i < M; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(isValid(str)){
                System.out.println("Accept");
            }else {
                System.out.println("Wrong");
            }
        }
    }
    public static boolean isValid(String s) {
        boolean hasNumber = false;
        if(s == "" || s.equals(""))
            return false;
        if(!((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'))){
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                hasNumber = true;
            }
            if(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) ){
                return false;
            }
        }
        return hasNumber;
    }
}
