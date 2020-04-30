package Test.July;

/**
 * leetCode 168: Excel表列名
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB

 */
public class Test168_convertToTitle_25_REMEMBER {

    public static void main(String[] args) {
       /* System.out.println(701 % 26);
        System.out.println(710 / 26);*/
        System.out.println(convertToTitle(701));
    }
    //这题看成是一个26进制的问题，但是与普通的进制不同，
    // 将n对26取余后，余数1~25对应'A'~'Y'，而0对应的是'Z'。
    // 所以在做题时注意这点。此外，还有个不同之处在于，
    // 虽然26对26取余为0，但是表达式中存在26（'Z'），这与我们常见的不同，
    // 比如二进制中就没有2（只有0， 1），十进制中没有10（0~9）
    // 。所以每次得到余数为0时，不仅要加入'Z'，还要在原数n中减去26
    // （1~26都可以，毕竟后面还要进行取余运算）。
    //

    public static String convertToTitle(int n) {
         StringBuilder sb = new StringBuilder();
         //定义一个余数
         int sub = 0;
         while(n != 0){
             sub = n % 27;
             if(sub == 0){
                 sb.append('Z');
                 n -= 26;
             }else{
                 char add = (char) (sub + 64);
                 System.out.println(add);
                 sb.append(add);
             }

             n = n / 26;
         }

         return sb.reverse().toString();
    }
}
