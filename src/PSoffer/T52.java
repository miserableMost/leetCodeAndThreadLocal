package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 17:51
 */
public class T52 {
    public static void main(String[] args) {

    }
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
