package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/20 19:00
 * 当 n 为偶数时，$$a^n = a^{n/2} * a^{n/2}$$
 * 当 n 为奇数时，$$a^n = a^{n/2} * a^{n/2} * a$$
 */
public class T9 {
    public static void main(String[] args) {

    }

    public double Power(double base, int exponent) {
        if(base == 0)
            return 0;
        if(base == 1)
            return 1;
        //获取指数的绝对值
        int exp = Math.abs(exponent);
        double res = positivePower(base,exp);
        return res;
    }

    private double positivePower(double base, int exp) {
        if(exp == 0)
            return 1;
        if(exp == 1)
            return base;

        double t = positivePower(base,exp >> 1);
        t *= t;
        //如果是奇数
        if((exp & 1) == 1)
            t *= base;
        return t;


    }
}
