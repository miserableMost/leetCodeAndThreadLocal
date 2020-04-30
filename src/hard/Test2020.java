package hard;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/3/24 21:08
 */
public class Test2020 {
    public static void main(String[] args) {
        Test2020 t = new Test2020();
        int test = t.test();
        System.out.println(test);
    }

    private int test() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        char[] arrs = s.toCharArray();
        char[] arrt = t.toCharArray();
        if(s.length() != t.length())
            throw new RuntimeException("输入错误");
        int len = s.length();
        //dp[i]当前匹配情况
        int[] dp = new int[len + 1];

        for (int i = 1; i <= s.length(); i++) {
            //如果两个对应位置相等
            if(arrs[i - 1] == arrt[i - 1]) {
                dp[i] = dp[i - 1];
                continue;   //跳过
            }
            //如果不相等,修改的就是dp[i - 1] + 1,或者交换
            for (int j = i + 1; j <= t.length(); j++) {
                //只有当交换时两处都对应才执行交换
                if(arrs[i - 1] == arrt[j - 1] && arrs[j - 1] == arrt[i - 1]) {
                    //交换两个元素
                    swap(arrs,i -1 ,j - 1);
                    break;
                }
            }
            dp[i] = dp[i - 1] + 1;
        }
        return dp[len];
    }

    private void swap(char[] arrs, int i, int j) {
        char temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
