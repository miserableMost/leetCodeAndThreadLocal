package medium2;

/**
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 *
 * 输出: "1A3B"
 *
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 *
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 *
 * 输出: "1A1B"
 *
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。。
 */
public class T299_getHint_9_27 {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        String hint = getHint(secret, guess);
        System.out.println(hint);
    }
    public static String getHint(String secret, String guess) {
       int bulls = 0,cows = 0;
       int[] dict = new int[10];
       //计数
        for (int i = 0; i < secret.charAt(i); i++) {
            dict[secret.charAt(i) - '0'] ++;
        }
       int b = 0;
        for (int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                bulls ++;
                dict[guess.charAt(i) - '0'] --;
                //本来有对应的，被你之前给用了
                if(guess.charAt(i) - '0' < 0)
                    cows --;   //表示之前cow用了bulls的数字
            }else if(dict[guess.charAt(i)] - '0' > 0) {
                cows ++;
                dict[guess.charAt(i) - '0'] --;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
