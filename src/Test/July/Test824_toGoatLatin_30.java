package Test.July;

/**
 * leetCode 824: 山羊拉丁文
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 *     如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 *     例如，单词"apple"变为"applema"。
 *
 *     如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *     例如，单词"goat"变为"oatgma"。
 *
 *     根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 *     例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 *
 * 返回将 S 转换为山羊拉丁文后的句子。
 */
public class Test824_toGoatLatin_30 {
    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }

    public static String toGoatLatin(String S) {
        String[] s = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char c = s[i].charAt(0);
            //如果是元音字符
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
               || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                sb.append(s[i]);
            }else{
                /*String sp = s[i].substring(1, s[i].length());
                StringBuilder spb = new StringBuilder(sp);
                spb.append(c);
                sb.append(spb);*/
                //如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾
                sb.append(s[i].substring(1) + c);
            }
            sb.append("ma");
            int temp = i + 1;
            while(temp > 0){
                sb.append("a");
                temp --;
            }
            if(i != s.length -1){
                sb.append(" ");
            }


        }
        return sb.toString();
    }
}
