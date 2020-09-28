package sougou;

/**
 * @author 李聪
 * @date 2020/9/5 18:00
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(getPasswordCount("12345"));
    }
    public static long getPasswordCount (String password) {
        // write code here
        if(password == null || password.equals("") || password == "")
            return 0;
        int res = 1;
        for (int i = 0; i < password.length(); i++) {
            int cur = password.charAt(i) - '0';
            //如果当前为奇数
            int sum = cur + 9;
            int curMax = (sum + 1) / 2 + 1;
            res *= curMax;

        }
        return res;
    }
}
