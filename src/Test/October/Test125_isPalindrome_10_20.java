package Test.October;

/**
 * leetCode 125 : 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Test125_isPalindrome_10_20 {
    public static void main(String[] args) {
        String s = "0P";
        boolean p = isPalindrome(s);
        System.out.println(p);
    }
    public static boolean isPalindrome(String s) {
        //用正则将这以外的全部替换掉
        //String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
       int left = 0,right = s.length() - 1;
       while(left < right) {
           while(!((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z') || (s.charAt(left) >= '0' && s.charAt(left) <= '9')) && left < right) {
               left ++;
           }
           while(!((s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z') || (s.charAt(right) >= '0' && s.charAt(right) <= '9')) && left < right) {
               right --;
           }
           //忽略大小写比较
           if(!(s.charAt(left) + "").equalsIgnoreCase(s.charAt(right) + "")){
               return false;
           }
           //被0P坑了
           /*if((s.charAt(left) != s.charAt(right))
                   && ((s.charAt(left) + 'A' - 'a') != s.charAt(right))
                   && ((s.charAt(right) + 'A' - 'a') != s.charAt(left))) {
               return false;
           }*/

           left ++;
           right --;
       }
       return true;
    }
}
