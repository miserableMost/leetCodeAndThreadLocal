package Test.April;

/** leetCode 748: 最短完整词
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 */
public class Test748_shortestCompletingWord {
    public static void main(String[] args) {
        String s ="+dfs";
        String licensePlate = "abcdeabcdeabcde";
        String[] words = {"abcdeabcdeabcde","pest","stew","show"};
        System.out.println(shortestCompletingWord(licensePlate,words));

    }


    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int plateLen = licensePlate.length();
        int wordsLen = words.length;
        //注明中有word的长度低于15,设置为16，保证第一次response为首个含有的单词
        String response = "ssssssssssssssss";
        String newPL = "";
        //将牌照精简
        for (int i = 0; i < plateLen; i++) {
            if((licensePlate.charAt(i) >= 65 && licensePlate.charAt(i)<=90) || (licensePlate.charAt(i) >= 97 && licensePlate.charAt(i)<=122)){
                newPL += licensePlate.charAt(i);
            }
        }
        //将牌照全部转为小写
        String lower = newPL.toLowerCase();

        //外层循环：将牌照与每个单词比较
        for (int i = 0; i < wordsLen; i++) {
            String word = words[i];
            StringBuffer wordBuffer = new StringBuffer(word);
            //设置每个单词是否包含牌照的标识
            boolean isContains = true;
           //将牌照的每个字符与单词比较
            for (int j = 0; j < lower.length(); j++) {
                //取出牌照的某个字符
                String c = lower.charAt(j)+"";
                //找到单词中与牌照某个字符对应的位置
                int index = wordBuffer.indexOf(c);
                if(index == -1){
                    //只要出现单词中没有牌照字符的情况，跳出进行下一个单词
                    isContains = false;
                    break;
                    //在单词中将这个位置用空替掉
                }else{
                    wordBuffer.replace(index,index+1,"");
                }
            }
            //如果存在，还要比较单词长度是否为最短，精华部分
            if(isContains)
                response = word.length() < response.length() ? word : response;


        }
        return response;

    }
}
