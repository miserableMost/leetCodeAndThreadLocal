package testAgin;

/**
 * @author 李聪
 * @date 2020/9/16 21:18
 */
public class 大数相加 {
    public static void main(String[] args) {
        大数相加 n = new 大数相加();
        System.out.println(n.bigAdd("123", "945"));
    }
    public String bigAdd(String a,String b){
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1,len2);
        int up = 0;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for (int i = 0; i < len; i++) {
            int r = i >= a.length() ? 0 : a.charAt(i) - '0';
            int c = i >= b.length() ? 0 : b.charAt(i) - '0';
            int cur = (r + c + up)%10;
            sb.append(cur);
            up = (r + c + up)/10;
        }
        if(up != 0){
            sb.append(up);
        }
        return sb.reverse().toString();

    }
}
