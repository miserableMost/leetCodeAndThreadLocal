package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 9:16
 */
public class T43 {
    public static void main(String[] args) {
        T43 t = new T43();
        String s = t.ReverseSentence(" ");
        System.out.println(s);
    }
    public String ReverseSentence(String str) {

        String[] s = str.split(" ");
        if(s == null || s.length == 0)
            return str;
        StringBuffer sb = new StringBuffer();
        for (int i = s.length - 1; i >= 0 ; i--) {
            if(i != 0) {
                sb.append(s[i] + " ");
            }else {
                sb.append(s[i]);
            }

        }

        return sb.toString();
    }
}
