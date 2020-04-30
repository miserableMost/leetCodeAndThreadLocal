package Test.August;

/**
 * leetCode 788：旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好
 */
public class D14_rotatedDigits_788 {
    public static void main(String[] args) {
        int i = rotatedDigits(10);
        System.out.println(i);
    }
    public static int rotatedDigits(int N) {
        int count = 0; //计算有效数字
        for (int i = 0; i < N; i++) {
            String s = Integer.toString(i);
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                //一旦出现347立刻退出
                if(c == '3' || c == '4' || c == '7'){
                    flag = false;
                    break;
                }
                //必须出现2569
                if(c == '2' || c == '5' || c == '6' || c == '9'){
                    flag = true;
                }
            }
            if (flag){
                count ++;
            }
        }
        return count;
    }
}
