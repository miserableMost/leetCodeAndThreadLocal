package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/29 10:07
 */
public class T48 {
    public static void main(String[] args) {
        String s = "-2147483649";
        T48 t48 = new T48();
        int i = t48.StrToInt(s);
        System.out.println(i);
        //System.out.println(s);
        System.out.println(147483649 + 2 * 1000000000);
    }
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int temp = 1;
        int before = 0;
        int sum = 0;
        int index = str.charAt(0) == '-' ? -1 : 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char cur = str.charAt(i);
            if(i == 0 && (cur == '+' ||cur == '-'))
                continue;
            if(cur > '9' || cur < '0')
                return 0;

            sum = (cur - '0') * temp + before;
            if(sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE)
                return 0;
            before = sum;
            temp *= 10;
        }
        return index * sum;
    }
}
