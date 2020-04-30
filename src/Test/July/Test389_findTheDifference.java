package Test.July;

/**
 * leetCode 389:找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class Test389_findTheDifference {
    public static void main(String[] args) {

    }
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            if(i < s.length()){
                count[s.charAt(i) - 'a'] ++;
            }

            count[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] < 0){
                return (char)(i + 'a');
            }
        }
        return 0;
    }
}
