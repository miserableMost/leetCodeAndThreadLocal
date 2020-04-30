package Test.April;

/*leetCode925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。



示例 1：

输入：name = "alex", typed = "aaleex"
输出：true
解释：'alex' 中的 'a' 和 'e' 被长按。

 */
public class Test925_isLongPressedName {
    public static void main(String[] args) {
        Test925_isLongPressedName test = new Test925_isLongPressedName();
        System.out.println(test.isLongPressedName("alex", "aaleex"));
        String m = "aaa";
        int dex = m.indexOf("a");
        System.out.println(dex);
    }

    public boolean isLongPressedName(String name, String typed) {
        //n指针指示name的位置
        int n = 0;
        for(int i=0;i<typed.length();i++) {
            if(n<name.length() && name.charAt(n)==typed.charAt(i)) {
                n++;
            }else {
                if(n>0 && typed.charAt(i)==typed.charAt(i-1)) {
                    //前一个相等证明重复，typed继续往后移
                    continue;
                }else {
                    return false;
                }
            }

        }
        return n == name.length();
    }
}