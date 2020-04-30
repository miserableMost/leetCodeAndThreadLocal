package Test.July;

/**
 * leetCode67: 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 */
public class Test67_addBinary {
    public static void main(String[] args) {
        String a = "110";
        String b = "10";
        System.out.println(addBinary(a,b));
    }



    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //定义是否进位
        int increment = 0;
        int aLength = a.length();
        int bLength = b.length();
        //两个字符串开始从末位依次相加
        for (int i = aLength - 1,j = bLength -1; i >= 0 || j>= 0 ; i--,j--) {
            //下一轮永远检查上一轮是否有进位
            int sum = increment;
            //短的老哥进行0补位
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            //字符串添加上这一轮加的结果
            sb.append(sum % 2);
            //这一轮是否进位
            increment = sum / 2;
        }
        //检查最后一波是否有进位
        sb.append(increment == 1 ? increment : "");
        return sb.reverse().toString();
    }
}
