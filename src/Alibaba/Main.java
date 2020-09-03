package Alibaba;



import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/1 18:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        String[] strs = arr.split(" ");
        int m = Integer.valueOf(strs[0]);
        int n = Integer.valueOf(strs[1]);
        String S = sc.nextLine();
        String T = sc.nextLine();
        List<String> lists = new ArrayList<>();
        boolean[] vistied = new boolean[S.length()];
        dfs(lists,S.toCharArray(),new StringBuilder(),0,vistied);
        for (String list : lists) {
            System.out.print(list + " ");
        }
        int ans = 0;
        for (String list : lists) {
            if(isSon(list,T)){
                ans ++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isSon(String list, String t) {
        if(list.length() > t.length())
            return false;
        int i = 0;
        int j = 0;
        while(i < list.length() && j < t.length()) {
            if(list.charAt(i) != t.charAt(j)) {
                j ++;
            }else {
                i ++;
                j ++;
            }

        }
        return i == list.length();
    }


    //获取所有的子串
    private static void dfs(List<String> lists, char[] arr, StringBuilder sb, int index,boolean[] vistied) {
        if(sb.length() > 0){
            lists.add(sb.toString());
        }
        for (int i = index; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i - 1] || vistied[i]){
                continue;
            }
            if(!vistied[i]) {
                vistied[i] = true;
                sb.append(arr[i]);
                dfs(lists,arr,sb,i + 1,vistied);
                sb.deleteCharAt(sb.length() - 1);
                vistied[i] = false;
            }

        }
    }

}
