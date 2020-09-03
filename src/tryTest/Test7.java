package tryTest;

/**
 * @author 李聪
 * @date 2020/7/29 23:02
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.println(getNumber(12));
    }
    public static int getNumber(int n) {
        if(n <= 5){
            return n;
        }
        return getNumber(n - 1) + getNumber(n - 3);
    }
}
