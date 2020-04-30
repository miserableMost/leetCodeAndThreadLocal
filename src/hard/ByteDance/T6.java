package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/3 23:37
 * 有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；但是操作的次数有上限m，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
 */
public class T6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        int ans = 0,left = 0,right = 0,numa = 0,numb = 0;
        while(right < n) {
            char cur = s.charAt(right);
            if(cur == 'a') numa ++;
            else numb ++;
            if(numa <= m || numb <= m) {
                right ++;
            }else {
                ans = Math.max(ans,right - left);
                if(s.charAt(left) == 'a') {
                    left ++;
                    numa --;
                }else {
                    left ++;
                    numb --;
                }
                right ++;
            }
        }
        ans = Math.max(ans,right - left);
        System.out.println(ans);
    }
}
