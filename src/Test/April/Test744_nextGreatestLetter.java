package Test.April;

/**leetCode744:寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。示例:
 *输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *     letters长度范围在[2, 10000]区间内。letters 仅由小写字母组成，最少包含两个不同的字母。目标字母target 是一个小写字母。
 */
public class Test744_nextGreatestLetter {

    public static void main(String[] args) {
        Test744_nextGreatestLetter test = new Test744_nextGreatestLetter();
        char[] letters = {'c','f','j'};
        char target = 'k';
        System.out.println(test.nextGreatestLetter(letters,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        char min = 'a';
        for (int i = 0; i < letters.length; i++) {
             if(letters[i]>target) {
                 min = letters[i];
                 break;
             }else{
                 min = letters[0];
             }

        }
        return min;
    }

}
