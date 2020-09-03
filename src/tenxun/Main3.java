package tenxun;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/8/23 19:17
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        Set<String> ans = new HashSet<>();
        boolean[] vistied = new boolean[s.length()];
        dfs(ans,s.toCharArray(),0,"",vistied);

        ArrayList<String> cur = new ArrayList<>(ans);

        Collections.sort(cur,(s1,s2) -> {
            int size1 = s1.length();
            int size2 = s2.length();
            int size = Math.min(size1,size2);
            int idx = 0;
            while(idx < size) {
                if(s1.charAt(idx) != s2.charAt(idx)){
                    return s1.charAt(idx) - s2.charAt(idx);
                }
                idx ++;
            }
            return s1.length() - s2.length();
        });

        for (int i = 0; i < cur.size(); i++) {
            if(i == n - 1){
                System.out.println(cur.get(i));
                break;
            }
        }
    }

    private static void dfs(Set<String> ans, char[] str, int start, String s, boolean[] vistied) {
        if(!s.equals("")){
            ans.add(s);
        }
        for (int i = start; i < str.length; i++) {
            if(!vistied[i]){
                vistied[i] = true;
                s += str[i];
                dfs(ans,str,i + 1,s,vistied);
                s = s.substring(0,s.length() - 1);
                vistied[i] = false;
            }
        }
    }

}
