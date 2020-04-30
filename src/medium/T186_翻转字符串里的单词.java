package medium;

/**
 * @author 李聪
 * @date 2020/4/11 15:49
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例：
 *
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * 注意：
 *
 *     单词的定义是不包含空格的一系列字符
 *     输入字符串中不会包含前置或尾随的空格
 *     单词与单词之间永远是以单个空格隔开的
 *
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 *
 */
public class T186_翻转字符串里的单词 {
    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','b','l','u','e'};
        reverseWords(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }
    public static void reverseWords(char[] s) {
        String str = String.valueOf(s);
        String[] strArr = str.split(" ");
        int index = 0;
        for (int i = strArr.length - 1; i >= 0; i--) {
            String temp = strArr[i];
            for (int j = 0; j < temp.length(); j++) {
                s[index ++] = temp.charAt(j);
            }
            if(i != 0) {
                s[index ++] = ' ';
            }

        }
    }
    //先对数组进行翻转，再对每一个单词进行翻转
    public void reverseWords2(char[] s) {
        int left = 0;
        int right = s.length-1;
        reverse(s,left,right);
        for(int i=0;i<right;i++){
            if(s[i]==' '){
                reverse(s,left,i-1);
                left = i+1;
            }
        }
        reverse(s,left,right);
    }

    public void reverse(char[] s ,int left ,int right){
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
