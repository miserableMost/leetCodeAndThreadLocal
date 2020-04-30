package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 9:08
 */
public class T42 {
    public static void main(String[] args) {
        String s = "abcXYZdef";
        T42 t = new T42();
        String s1 = t.LeftRotateString(s, 3);
        System.out.println(s1);
    }
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0)
            return "";
        int m = n % str.length();
        String a = str.substring(0,m);
        String b = str.substring(m);
        return b + a;
    }
}
