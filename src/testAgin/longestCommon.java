package testAgin;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/9/17 11:01
 */
public class longestCommon {
    public static void main(String[] args) {
        String[] strs = {"abd","abdc","ag","a"};
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        StringBuilder ans = new StringBuilder();
        int len = Math.min(first.length,last.length);
        int i = 0;
        while(i < len){
            if(first[i] == last[i]){
                ans.append(first[i]);
                i ++;
            }else {
                break;
            }
        }
        System.out.println(ans.toString());
    }
}
