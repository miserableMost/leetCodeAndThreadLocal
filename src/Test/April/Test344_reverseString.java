package Test.April;

/**
 * leetCode:344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */
public class Test344_reverseString {
    public static void main(String[] args) {
        char[] s = {'a','e','l','o','p','l'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }

        for (int i = 0; i < len; i++) {
            System.out.print(s[i]+",");
        }
    }
}
