package Test.August;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3。
 */
public class D1_numJewelsInStones_771 {

    public static void main(String[] args) {
         String J = "aA";
         String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));
    }
    public static int numJewelsInStones(String J, String S) {
       /* int count = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < J.length(); i++) {
            list.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(list.contains(S.charAt(i)))
                count ++;
        }
        return count;*/
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            //取下此时的字符串--相当于一个字符--关键
            //String temp = S.substring(i, i + 1);
            //判断J中是否包含
            if (J.indexOf(S.charAt(i)) != -1) {
                //b包含
                num++;
            }
        }
        return num;
    }
}
