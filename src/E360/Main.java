package E360;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(str.length() == 0 || str.length() > 10){
                ans ++;
                continue;
            }
            for (int j = 0; j < str.length(); j++) {
                if(!((str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') || (str.charAt(j) >= 'a' && str.charAt(j) <= 'z'))){
                    ans ++;
                    break;
                }
            }
        }
        System.out.println(n - ans);
    }
}
