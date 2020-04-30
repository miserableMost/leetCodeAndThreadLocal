package Test.July;

/**
 * leetCode 520:检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 *     全部字母都是大写，比如"USA"。
 *     单词中所有字母都不是大写，比如"leetcode"。
 *     如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 *
 * 否则，我们定义这个单词没有正确使用大写字母。
 */
public class Test520_detectCapitalUse_7_24 {
    public static void main(String[] args) {
        boolean b = detectCapitalUse("GooglG");
        System.out.println(b);
    }
    public static boolean detectCapitalUse(String word) {
         int length = word.length();
         if(length <= 1){
             return true;
         }
        for (int i = 1; i < length; i++) {
            //如果第一个是小写的
            if(word.charAt(0) >= 'a'){
                if(word.charAt(i) < 'a'){
                    return false;
                }
            }else {
                //检查第二个字母是否是小写
                if(word.charAt(1) >= 'a'){
                    if(word.charAt(i) < 'a')
                        return false;
                }else{
                    if(word.charAt(i) >= 'a')
                        return false;
                }
            }
        }
        return true;
    }
}
