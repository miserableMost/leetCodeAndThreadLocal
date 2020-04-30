package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/4 19:21
 */
public class T9 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strs = new String[N];
        for(int i = 0;i < N;i ++) {
            strs[i] = sc.next();
        }
        for(int i = 0;i < N; i ++) {
            String s = strs[i];
            int len = s.length();
            int l = 0,r = 0,countL = 1,countR = 1;
            while(r < len - 1) {
                r ++;
                while(r < len && s.charAt(r) == s.charAt(l)) {
                    r ++;
                    countL ++;
                }
                if(countL >= 3) {
                    s = s.substring(0,l + 2) + s.substring(r);
                }
                if(countL == 2) {
                    l = r;
                    r ++;
                    while(r < len && s.charAt(r) == s.charAt(l)) {
                        countR ++;
                        r ++;
                    }
                    if(countR >= 2)
                        s = s.substring(0,l + 1) + s.substring(r);

                }
                l ++;
                countL = 1;
            }
            System.out.println(s);

        }
    }*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder(sc.nextLine());
                for(int j = 2; j < sb.length(); j++){
                    if(sb.charAt(j) == sb.charAt(j - 1)
                            && sb.charAt(j - 1) == sb.charAt(j - 2)){
                        sb.deleteCharAt(j);
                        j--;
                    }
                    else if(isPattern(sb, j - 3, j)){
                        sb.deleteCharAt(j);
                        j--;
                    }
                }
                System.out.println(sb.toString());
            }
        }
        sc.close();
    }
    public static boolean isPattern(StringBuilder sb, int i, int j){
        if(i < 0) return false;
        return sb.charAt(i) == sb.charAt(i + 1) &&
                sb.charAt(j - 1) == sb.charAt(j);
    }
}
