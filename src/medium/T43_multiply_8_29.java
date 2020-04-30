package medium;

/**
 * leetCode 43 : 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class T43_multiply_8_29 {
     static StringBuffer res = new StringBuffer();
    public static void main(String[] args) {
        String multiply = multiply("123", "456");
        System.out.println(multiply);
    }
    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return "";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        if((n1 == 1 && (num1.charAt(0) - '0' == 0)) || (n2 == 1 && (num2.charAt(0) - '0' == 0)) ){
            return "0";
        }
        String lstr = num1;
        String dstr = num2;
        if(n2 > n1){
            lstr = num2;
            dstr = num1;
        }
        int sum = 0;
        int index = 0;

        for (int i = dstr.length() - 1; i >= 0; i--) {
            StringBuffer sb = new StringBuffer();
            int b = dstr.charAt(i) - '0';
            int up = 0;
            for (int j = lstr.length() - 1; j >= 0; j--) {
                int a = lstr.charAt(j) - '0';
                int s = a * b + up;
                sb.append(s % 10);
                up = s / 10;
            }
            if(up != 0){
                sb.append(up);
            }
            //将这个结果反转
            sb.reverse();
            int temp = index;
            while(temp > 0){
                sb.append("0");
                temp --;
            }
            index ++;
            //两个整数相加
            add(sb, res);
        }
        return res.toString();
    }
    private static void add(StringBuffer s1,StringBuffer s2){
        int l1 = s1.length();
        if(s2 == null || s2.length() == 0){
            res = s1;
            return;
        }
        int l2 = s2.length();
        int len1 = l1 - 1;
        int len2 = l2 - 1;
        int up = 0;
        StringBuffer sp = new StringBuffer();
        while(len1 >= 0 || len2 >= 0){

            int n1 = len1 >= 0 ? s1.charAt(len1--) - '0' : 0;
            int n2 = len2 >= 0 ? s2.charAt(len2--) - '0' : 0;
            int sum = n1 + n2 + up;
            up = sum / 10;
            sp.append(sum % 10);
        }
        if(up != 0){
            sp.append(up);
        }
        res = sp.reverse();
    }
}
